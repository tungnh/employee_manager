package com.example.employee_manager.service.mapper;

import com.example.employee_manager.domain.Project;
import com.example.employee_manager.service.dto.ProjectDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectMapper implements EntityMapper<ProjectDTO, Project> {
    @Override
    public Project toEntity(ProjectDTO dto) {
        if (dto == null) {
            return null;
        }
        Project project = new Project();
        project.setId(dto.getId());
        project.setName(dto.getName());
        project.setLeaderId(dto.getLeaderId());
        project.setPart(dto.getPart());
        project.setStatus(dto.getStatus());
        project.setScale(dto.getScale());
        project.setLanguage(dto.getLanguage());
        project.setFramework(dto.getFramework());
        project.setContent(dto.getContent());
        project.setDescription(dto.getDescription());
        project.setUrl(dto.getUrl());
        project.setStartDate(dto.getStartDate());
        project.setEndDate(dto.getEndDate());
        project.setCreatedBy(dto.getCreatedBy());
        project.setCreatedDate(dto.getCreatedDate());
        project.setLastModifiedDate(dto.getLastModifiedDate());
        project.setLastModifiedBy(dto.getLastModifiedBy());
        return project;
    }

    @Override
    public ProjectDTO toDto(Project entity) {
        if (entity == null) {
            return null;
        }
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(entity.getId());
        projectDTO.setName(entity.getName());
        projectDTO.setLeaderId(entity.getLeaderId());
        projectDTO.setPart(entity.getPart());
        projectDTO.setStatus(entity.getStatus());
        projectDTO.setScale(entity.getScale());
        projectDTO.setLanguage(entity.getLanguage());
        projectDTO.setFramework(entity.getFramework());
        projectDTO.setContent(entity.getContent());
        projectDTO.setDescription(entity.getDescription());
        projectDTO.setUrl(entity.getUrl());
        projectDTO.setStartDate(entity.getStartDate());
        projectDTO.setEndDate(entity.getEndDate());
        projectDTO.setCreatedBy(entity.getCreatedBy());
        projectDTO.setCreatedDate(entity.getCreatedDate());
        projectDTO.setLastModifiedDate(entity.getLastModifiedDate());
        projectDTO.setLastModifiedBy(entity.getLastModifiedBy());
        if (entity.getEmployeeLeader() != null) {
        	projectDTO.setLeaderFirstName(entity.getEmployeeLeader().getFirstName());
        	projectDTO.setLeaderLastName(entity.getEmployeeLeader().getLastName());
        }
        return projectDTO;
    }

    @Override
    public List<Project> toEntity(List<ProjectDTO> dtoList) {
        if (dtoList.isEmpty()) {
            return null;
        }
        List<Project> projectList = new ArrayList<>(dtoList.size());
        for (ProjectDTO projectDTO : dtoList) {
            projectList.add(toEntity(projectDTO));
        }
        return projectList;
    }

    @Override
    public List<ProjectDTO> toDto(List<Project> entityList) {
        if (entityList == null) {
            return null;
        }
        List<ProjectDTO> projectDTOList = new ArrayList<>(entityList.size());
        for (Project project : entityList) {
            projectDTOList.add(toDto(project));
        }
        return projectDTOList;
    }

    @Override
    public void partialUpdate(Project entity, ProjectDTO dto) {
    }
}