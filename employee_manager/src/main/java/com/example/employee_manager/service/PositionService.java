package com.example.employee_manager.service;


import com.example.employee_manager.domain.Position;
import com.example.employee_manager.service.dto.PositionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.example.employee_manager.service.dto.PositionDTO;
import java.util.List;
import java.util.Map;
import java.util.Optional;
public interface PositionService {
    Optional<PositionDTO> findById(int id);
    List<PositionDTO> getAll();
    PositionDTO save(PositionDTO positionDto);
    PositionDTO update(PositionDTO positionDto);
    void delete(int id);
    List<PositionDTO> searchByName(String name);
    List<PositionDTO> getPagingAndSort(int page);

}