package com.example.employee_manager.service;

import com.example.employee_manager.service.dto.ProjectDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    Optional<ProjectDTO> findById(int id);

    List<ProjectDTO> getAll();

    ProjectDTO save(ProjectDTO projectDTO);

    ProjectDTO update(ProjectDTO projectDTO);

    void delete(int id);

    Page<ProjectDTO> pageAll(String search, Pageable pageable);
}