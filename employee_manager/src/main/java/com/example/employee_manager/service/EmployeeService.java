package com.example.employee_manager.service;

import com.example.employee_manager.service.dto.CertificateDTO;
import com.example.employee_manager.service.dto.EmployeeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Page<EmployeeDTO> findAll(String search, Pageable pageable);
    Optional<EmployeeDTO> findById(int id);
    EmployeeDTO save(EmployeeDTO employeeDTO);
    EmployeeDTO update(EmployeeDTO employeeDTO);
    void delete(int id);
}
