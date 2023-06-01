package com.example.employee_manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.employee_manager.service.dto.PositionDTO;

public interface PositionService {
    Optional<PositionDTO> findById(int id);
    List<PositionDTO> getAll();
    PositionDTO save(PositionDTO positionDto);
    PositionDTO update(PositionDTO positionDto);
    void delete(int id);
    Page<PositionDTO> pageAll(String search, Pageable pageable);
}
