package com.example.employee_manager.service.serviceImpl;

import com.example.employee_manager.domain.Position;
import com.example.employee_manager.repository.PositionRepository;
import com.example.employee_manager.service.PositionService;
import com.example.employee_manager.service.dto.PositionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PositionServiceImp implements PositionService {


    @Override
    public Page<PositionDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<PositionDTO> findOne(Integer id) {
        return Optional.empty();
    }

    @Override
    public PositionDTO save(PositionDTO positionDTO) {
        return null;
    }

    @Override
    public PositionDTO update(PositionDTO positionDTO) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
