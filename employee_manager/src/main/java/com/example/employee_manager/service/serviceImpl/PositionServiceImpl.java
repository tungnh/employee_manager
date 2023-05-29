package com.example.employee_manager.service.serviceImpl;

import com.example.employee_manager.domain.Position;
import com.example.employee_manager.repository.PositionRepository;
import com.example.employee_manager.service.PositionService;
import com.example.employee_manager.service.dto.PositionDTO;
import com.example.employee_manager.service.mapper.PositionMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PositionServiceImpl implements PositionService {

    public final PositionRepository positionRepository;
    public final PositionMapper positionMapper;

    public PositionServiceImpl(PositionRepository positionRepository, PositionMapper positionMapper) {
        this.positionRepository = positionRepository;
        this.positionMapper = positionMapper;
    }


    @Override
    public Optional<PositionDTO> findById(int id) {
        Optional<Position> positionOptional = positionRepository.findById(id);
        if (positionOptional.isPresent()) {
            Position position = positionOptional.get();
            PositionDTO positionDTO = positionMapper.toDto(position);
            return Optional.of(positionDTO);
        } else {
            return Optional.empty();
        }

    }

    @Override
    public List<PositionDTO> getAll() {
        return positionMapper.toDto(positionRepository.findAll());
    }

    @Override
    public PositionDTO save(PositionDTO positionDto) {
        Position position = positionMapper.toEntity(positionDto);
        position = positionRepository.save(position);
        return positionMapper.toDto(position);
    }

    @Override
    public PositionDTO update(PositionDTO positionDto) {
        return null;
    }

    @Override
    public void delete(int id) {
        positionRepository.deleteById(id);
    }
}

