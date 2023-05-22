package com.example.employee_manager_pr.model.serviceImpl;

import com.example.employee_manager_pr.dto.request.RegisterRequest;
import com.example.employee_manager_pr.model.entity.Employee;
import com.example.employee_manager_pr.model.repository.EmployeeRepository;
import com.example.employee_manager_pr.model.service.EmployeeService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee save(RegisterRequest registerRequest) {
        if (employeeRepository.existsByUserName(registerRequest.getUsername())) {
            throw new UsernameNotFoundException("Error: User is already");
        }
        if (employeeRepository.existsByEmail(registerRequest.getEmail())) {
            throw new UsernameNotFoundException("Error: Email is already.");
        }
        Employee employee = new Employee();
        employee.setUserName(registerRequest.getUsername());
        employee.setEmail(registerRequest.getEmail());
        employee.setPassword(registerRequest.getPassword());
        employee.setRole(registerRequest.getRole());
        return employeeRepository.save(employee);
    }

}
