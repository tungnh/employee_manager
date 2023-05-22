package com.example.employee_manager.service.serviceImpl;

import com.example.employee_manager.service.dto.request.RegisterRequest;
import com.example.employee_manager.domain.Employee;
import com.example.employee_manager.repository.EmployeeRepository;
import com.example.employee_manager.service.EmployeeService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private PasswordEncoder encoder;

    public EmployeeServiceImp(EmployeeRepository employeeRepository, PasswordEncoder encoder) {
        this.employeeRepository = employeeRepository;
        this.encoder = encoder;
    }



    @Override
    public Employee save(RegisterRequest registerRequest) {
        if (employeeRepository.existsByUserName(registerRequest.getUserName())) {
            throw new UsernameNotFoundException("Error: User is already");
        }
        if (employeeRepository.existsByEmail(registerRequest.getEmail())) {
            throw new UsernameNotFoundException("Error: Email is already.");
        }
        Employee employee = new Employee();
        employee.setUserName(registerRequest.getUserName());
        employee.setEmail(registerRequest.getEmail());
        employee.setPassword(encoder.encode(registerRequest.getPassword()));
        employee.setRole(registerRequest.getRole());
        return employeeRepository.save(employee);
    }

}
