package com.example.employee_manager.repository;

import com.example.employee_manager.domain.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill,Integer> {
    Page<Skill> findByNameContaining(String search, Pageable pageable);
    List<Skill> findByEmployeeId(int id);
}
