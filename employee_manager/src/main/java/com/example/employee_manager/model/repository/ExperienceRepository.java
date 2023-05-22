package com.example.employee_manager.model.repository;

import com.example.employee_manager.model.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience,Integer> {
}
