package com.example.employee_manager.service.mapper;

import com.example.employee_manager.domain.Position;
import com.example.employee_manager.service.dto.PositionDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PositionMapper implements EntityMapper<PositionDTO, Position> {
    @Override
    public Position toEntity(PositionDTO dto) {
        if (dto == null) {
            return null;
        }
        Position position = new Position();
        position.setId(dto.getId());
        position.setName(dto.getName());
        position.setDescription(dto.getDescription());
        position.setStatus(dto.getStatus());
        position.setCreatedBy(dto.getCreatedBy());
        position.setCreatedDate(dto.getCreatedDate());
        position.setLastModifiedBy(dto.getLastModifiedBy());
        position.setLastModifiedDate(dto.getLastModifiedDate());
        return position;
    }

    @Override
    public PositionDTO toDto(Position entity) {
        if (entity == null) {
            return null;
        }
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setId(entity.getId());
        positionDTO.setName(entity.getName());
        positionDTO.setDescription(entity.getDescription());
        positionDTO.setStatus(entity.getStatus());
        positionDTO.setCreatedBy(entity.getCreatedBy());
        positionDTO.setCreatedDate(entity.getCreatedDate());
        positionDTO.setLastModifiedBy(entity.getLastModifiedBy());
        positionDTO.setLastModifiedDate(entity.getLastModifiedDate());
        return positionDTO;
    }

    @Override
    public List<Position> toEntity(List<PositionDTO> dtoList) {
        if (dtoList.isEmpty()) {
            return null;
        }
        List<Position> positionList = new ArrayList<>(dtoList.size());
        for (PositionDTO positionDTO : dtoList) {
            positionList.add(toEntity(positionDTO));
        }
        return positionList;
    }

    @Override
    public List<PositionDTO> toDto(List<Position> entityList) {
        if (entityList == null) {
            return null;
        }
        List<PositionDTO> positionDTOList = new ArrayList<>(entityList.size());
        for (Position position : entityList) {
            positionDTOList.add(toDto(position));
        }
        return positionDTOList;
    }

    @Override
    public void partialUpdate(Position entity, PositionDTO dto) {
    }
}
