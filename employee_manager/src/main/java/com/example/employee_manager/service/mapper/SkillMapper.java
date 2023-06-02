package com.example.employee_manager.service.mapper;

import com.example.employee_manager.domain.Skill;
import com.example.employee_manager.service.dto.SkillDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SkillMapper implements EntityMapper<SkillDTO, Skill>{

    @Override
    public Skill toEntity(SkillDTO dto) {
        if (dto == null) {
            return null;
        }

        Skill skill = new Skill();
        skill.setId(dto.getId());
        skill.setName(dto.getName());
        skill.setLevel(dto.getLevel());
        skill.setMonth(dto.getMonth());
        skill.setYear(dto.getYear());
        skill.setSelfAssessment(dto.getSelfAssessment());
        skill.setExternalAssessment(dto.getExternalAssessment());
        skill.setDescription(dto.getDescription());
        skill.setCreatedBy(dto.getCreatedBy());
        skill.setCreatedDate(dto.getCreatedDate());
        skill.setLastModifiedBy(dto.getLastModifiedBy());
        skill.setLastModifiedDate(dto.getLastModifiedDate());

        return skill;
    }

    @Override
    public SkillDTO toDto(Skill entity) {
        if (entity == null) {
            return null;
        }

        SkillDTO skillDTO = new SkillDTO();
        skillDTO.setId(entity.getId());
        skillDTO.setName(entity.getName());
        skillDTO.setLevel(entity.getLevel());
        skillDTO.setMonth(entity.getMonth());
        skillDTO.setYear(entity.getYear());
        skillDTO.setSelfAssessment(entity.getSelfAssessment());
        skillDTO.setExternalAssessment(entity.getExternalAssessment());
        skillDTO.setDescription(entity.getDescription());
        skillDTO.setCreatedBy(entity.getCreatedBy());
        skillDTO.setCreatedDate(entity.getCreatedDate());
        skillDTO.setLastModifiedBy(entity.getLastModifiedBy());
        skillDTO.setLastModifiedDate(entity.getLastModifiedDate());

        return skillDTO;
    }

    @Override
    public List<Skill> toEntity(List<SkillDTO> dtoList) {
        if (dtoList.isEmpty()) {
            return null;
        }
        List<Skill> skills = new ArrayList<>(dtoList.size());
        for (SkillDTO skillDTO : dtoList) {
            skills.add(toEntity(skillDTO));
        }
        return skills;
    }

    @Override
    public List<SkillDTO> toDto(List<Skill> entityList) {
        if (entityList == null) {
            return null;
        }
        List<SkillDTO> skillDTO = new ArrayList<>(entityList.size());
        for (Skill skill : entityList) {
            skillDTO.add(toDto(skill));
        }
        return skillDTO;
    }

    @Override
    public void partialUpdate(Skill entity, SkillDTO dto) {

    }
}
