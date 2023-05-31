package com.example.employee_manager.repository;

import com.example.employee_manager.domain.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer> {
    Page<Project> findByNameContaining(String name, Pageable pageable);
}