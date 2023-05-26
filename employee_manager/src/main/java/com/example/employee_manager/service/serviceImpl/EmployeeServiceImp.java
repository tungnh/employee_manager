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



}
