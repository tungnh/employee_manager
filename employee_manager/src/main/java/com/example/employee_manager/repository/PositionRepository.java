package com.example.employee_manager.repository;

import com.example.employee_manager.domain.Department;
import com.example.employee_manager.domain.Position;
import com.example.employee_manager.service.dto.PositionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {
    Page<Position> findByNameContaining(String name, Pageable pageable);
}