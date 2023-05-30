package com.example.employee_manager.service;

import com.example.employee_manager.service.dto.EmployeeDTO;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<EmployeeDTO> findAll();
    Optional<EmployeeDTO> findById(int id);
    EmployeeDTO save(EmployeeDTO employeeDTO);
    EmployeeDTO update(EmployeeDTO employeeDTO);
    void delete(int id);
}
