package com.example.employee_manager.service.serviceImpl;

import com.example.employee_manager.domain.Employee;
import com.example.employee_manager.domain.Project;
import com.example.employee_manager.repository.EmployeeRepository;
import com.example.employee_manager.repository.ProjectRepository;
import com.example.employee_manager.service.ProjectService;
import com.example.employee_manager.service.dto.ProjectDTO;
import com.example.employee_manager.service.mapper.ProjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProjectServiceImp implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final EmployeeRepository employeeRepository;

    public ProjectServiceImp(ProjectRepository projectRepository, ProjectMapper projectMapper, EmployeeRepository employeeRepository) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Optional<ProjectDTO> findById(int id) {
        return projectRepository.findById(id).map(projectMapper::toDto);
    }

    @Override
    public List<ProjectDTO> getAll() {
        return projectMapper.toDto(projectRepository.findAll());
    }

    @Override
    public ProjectDTO save(ProjectDTO projectDTO) {
        Project project = projectMapper.toEntity(projectDTO);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Optional<Employee> optionalEmployee = employeeRepository.findOneByUserName(userDetails.getUsername());
            if (optionalEmployee.isPresent()) {
                Employee user = optionalEmployee.get();
                project.setCreatedBy(user.getUserName());
            }
        }
        project.setCreatedDate(new Date());
        project = projectRepository.save(project);
        return projectMapper.toDto(project);
    }

    @Override
    public ProjectDTO update(ProjectDTO projectDTO) {
        Project project = projectMapper.toEntity(projectDTO);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Optional<Employee> optionalEmployee = employeeRepository.findOneByUserName(userDetails.getUsername());
            if (optionalEmployee.isPresent()) {
                Employee user = optionalEmployee.get();
                project.setLastModifiedBy(user.getUserName());
            }
        }
        project.setLastModifiedDate(new Date());
        project.setId(projectDTO.getId());
        projectRepository.save(project);
        ProjectDTO projectDTO1 = projectMapper.toDto(project);
        return projectDTO1;
    }

    @Override
    public void delete(int id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Page<ProjectDTO> pageAll(String search, Pageable pageable) {
        if (search == null || search.isEmpty()) {
            return projectRepository.findAll(pageable).map(projectMapper::toDto);
        } else {
            return projectRepository.findByNameContaining(search, pageable).map(projectMapper::toDto);
        }
    }
}