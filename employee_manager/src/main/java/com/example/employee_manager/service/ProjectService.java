package com.example.employee_manager.service;

import com.example.employee_manager.domain.Project;
import com.example.employee_manager.service.dto.ProjectDTO;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
        Optional<ProjectDTO> findById(int id);
    List<ProjectDTO> getAll();
    ProjectDTO save(ProjectDTO projectDTO);
    ProjectDTO update(ProjectDTO projectDTO);
    void delete(int id);
    List<ProjectDTO> searchByName(String name);
}
