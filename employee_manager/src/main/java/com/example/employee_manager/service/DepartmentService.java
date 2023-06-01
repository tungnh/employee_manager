package com.example.employee_manager.service;

import com.example.employee_manager.service.dto.DepartmentDTO;
import com.example.employee_manager.service.dto.ProjectDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Optional<DepartmentDTO> findById(int id);

    List<DepartmentDTO> getAll();

    DepartmentDTO save(DepartmentDTO departmentDTO);

    DepartmentDTO update(DepartmentDTO departmentDTO);

    void delete(int id);

    Page<DepartmentDTO> pageAll(String search, Pageable pageable);
}