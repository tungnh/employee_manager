package com.example.employee_manager.service.mapper;

import com.example.employee_manager.domain.Department;
import com.example.employee_manager.domain.Employee;
import com.example.employee_manager.domain.Experience;
import com.example.employee_manager.service.dto.ExperienceDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ExperienceMapper implements EntityMapper<ExperienceDTO, Experience>{
    @Override
    public Experience toEntity(ExperienceDTO dto) {
        if (dto == null) {
            return null;
        }
        Experience experience = new Experience();
        experience.setId(dto.getId());
        experience.setName(dto.getName());
        experience.setCompanyName(dto.getCompanyName());
        experience.setPart(dto.getPart());
        experience.setScale(dto.getScale());
        experience.setLanguage(dto.getLanguage());
        experience.setFramework(dto.getFramework());
        experience.setOs(dto.getOs());
        experience.setStartWork(dto.getStartWork());
        experience.setEndWork(dto.getEndWork());
        experience.setContent(dto.getContent());
        experience.setDescription(dto.getDescription());
        experience.setUrl(dto.getUrl());
        experience.setCreatedBy(dto.getCreatedBy());
        experience.setCreatedDate(dto.getCreatedDate());
        experience.setLastModifiedBy(dto.getLastModifiedBy());
        experience.setLastModifiedDate(dto.getLastModifiedDate());

        return experience;
    }

    @Override
    public ExperienceDTO toDto(Experience entity) {
        if (entity == null) {
            return null;
        }

        ExperienceDTO experienceDTO = new ExperienceDTO();
        experienceDTO.setId(entity.getId());
        experienceDTO.setName(entity.getName());
        experienceDTO.setCompanyName(entity.getCompanyName());
        experienceDTO.setPart(entity.getPart());
        experienceDTO.setScale(entity.getScale());
        experienceDTO.setLanguage(entity.getLanguage());
        experienceDTO.setFramework(entity.getFramework());
        experienceDTO.setOs(entity.getOs());
        experienceDTO.setStartWork(entity.getStartWork());
        experienceDTO.setEndWork(entity.getEndWork());
        experienceDTO.setContent(entity.getContent());
        experienceDTO.setDescription(entity.getDescription());
        experienceDTO.setUrl(entity.getUrl());

        return experienceDTO;
    }

    @Override
    public List<Experience> toEntity(List<ExperienceDTO> dtoList) {
        if (dtoList.isEmpty()) {
            return null;
        }
        List<Experience> experienceList = new ArrayList<>(dtoList.size());
        for (ExperienceDTO experienceDTO : dtoList) {
            experienceList.add(toEntity(experienceDTO));
        }
        return experienceList;
    }

    @Override
    public List<ExperienceDTO> toDto(List<Experience> entityList) {
        if (entityList == null) {
            return null;
        }
        List<ExperienceDTO> experienceDTO = new ArrayList<>(entityList.size());
        for (Experience experience : entityList) {
            experienceDTO.add(toDto(experience));
        }
        return experienceDTO;
    }

    @Override
    public void partialUpdate(Experience entity, ExperienceDTO dto) {

    }
}
