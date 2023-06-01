package com.example.employee_manager.service;

import com.example.employee_manager.service.dto.DepartmentDTO;
import com.example.employee_manager.service.dto.ExperienceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ExperienceService {
    Optional<ExperienceDTO> findById(int id);

    Page<ExperienceDTO> findAll(String search, Pageable pageable);

    ExperienceDTO save(ExperienceDTO experienceDTO);

    ExperienceDTO update(ExperienceDTO experienceDTO);

    void delete(int id);
}
