package com.example.employee_manager.service;

import com.example.employee_manager.service.dto.SkillDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface SkillService {
    Optional<SkillDTO> findById(int id);
    Page<SkillDTO> findAll(String search, Pageable pageable);
    SkillDTO save(SkillDTO skillDTO);
    SkillDTO update(SkillDTO skillDTO);
    void delete(int id);
}
