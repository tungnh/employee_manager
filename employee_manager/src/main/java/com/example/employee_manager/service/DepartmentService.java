package com.example.employee_manager.service;

import com.example.employee_manager.service.dto.DepartmentDTO;
import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Optional<DepartmentDTO> findById(int id);

    List<DepartmentDTO> getAll();

    DepartmentDTO save(DepartmentDTO departmentDTO);

    DepartmentDTO update(DepartmentDTO departmentDTO);

    void delete(int id);

    List<DepartmentDTO> searchByName(String name);
}