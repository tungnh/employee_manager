package com.example.employee_manager.repository;

import com.example.employee_manager.domain.Department;
import com.example.employee_manager.domain.Experience;
import com.example.employee_manager.domain.Skill;
import com.example.employee_manager.service.dto.ExperienceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience,Integer> {
    Page<Experience> findByNameContaining(String search, Pageable pageable);
    List<Experience> findByEmployeeId(int id);
}
