package com.example.employee_manager.service.serviceImpl;

import com.example.employee_manager.domain.Project;
import com.example.employee_manager.service.ProjectService;
import com.example.employee_manager.service.dto.ProjectDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImp implements ProjectService {
    @Override
    public List<Project> findAll() {
        return null;
    }

    @Override
    public Project findById(Integer id) {
        return null;
    }

    @Override
    public Project save(ProjectDTO projectDto) {
        return null;
    }

    @Override
    public Project update(ProjectDTO projectDto) {
        return null;
    }

    @Override
    public Project delete(Integer id) {
        return null;
    }
}
