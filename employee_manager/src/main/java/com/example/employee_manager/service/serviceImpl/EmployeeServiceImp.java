package com.example.employee_manager.service.serviceImpl;

import com.example.employee_manager.service.dto.EmployeeDTO;
import com.example.employee_manager.domain.Employee;
import com.example.employee_manager.repository.EmployeeRepository;
import com.example.employee_manager.service.EmployeeService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private EmployeeRepository employeeRepository;


    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return null;
    }

    @Override
    public Employee save(EmployeeDTO register) {
        if (employeeRepository.existsByUserName(register.getUserName())) {
            throw new UsernameNotFoundException("Error: User is already");
        }
        if (employeeRepository.existsByEmail(register.getEmail())) {
            throw new UsernameNotFoundException("Error: Email is already.");
        }
        Employee employee = new Employee();
        employee.setUserName(register.getUserName());
        employee.setFirstName(register.getFirstName());
        employee.setLastName(register.getLastName());
        employee.setEmail(register.getEmail());
        employee.setPhoneNumber(register.getPhoneNumber());
        employee.setCitzenId(register.getCitzenId());
        employee.setBirthday(register.getBirthday());
        employee.setSex(register.getSex());
        employee.setNationality(register.getNationality());
        employee.setNation(register.getNation());
        employee.setAddress(register.getAddress());
        employee.setIssuedOn(register.getIssuedOn());
        employee.setIssueBy(register.getIssueBy());
        employee.setStartWork(register.getStartWork());
        employee.setEndWork(register.getEndWork());
        employee.setCoefficientsSalary(register.getCoefficientsSalary());
        employee.setEducation(register.getEducation());
        employee.setRole(register.getRole());
        employee.setAccessToken(register.getAccessToken());
        employee.setStatus(register.getStatus());
        employee.setCreatedBy(employeeRepository.findByUserName(employee.getUserName()));
        employee.setCreatedDate(register.getCreatedDate(LocalDate.now()));
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(EmployeeDTO employeeDto) {
        return null;
    }

    @Override
    public Employee delete(Integer id) {
        return null;
    }

}
