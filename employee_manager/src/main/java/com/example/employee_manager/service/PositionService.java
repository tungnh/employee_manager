package com.example.employee_manager.service;


import com.example.employee_manager.service.dto.PositionDTO;
import java.util.List;
import java.util.Optional;

public interface PositionService {
    Optional<PositionDTO> findById(int id);
    List<PositionDTO> getAll();
    PositionDTO save(PositionDTO positionDto);
    PositionDTO update(PositionDTO positionDto);
    void delete(int id);
}
