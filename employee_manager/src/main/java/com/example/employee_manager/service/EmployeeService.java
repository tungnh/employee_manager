package com.example.employee_manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.employee_manager.service.dto.EmployeeDTO;

public interface EmployeeService {
    List<EmployeeDTO> findAll();
    Page<EmployeeDTO> findAll(String search, Pageable pageable);
    Optional<EmployeeDTO> findById(int id);
    EmployeeDTO save(EmployeeDTO employeeDTO);
    EmployeeDTO update(EmployeeDTO employeeDTO);
    void delete(int id);
}
