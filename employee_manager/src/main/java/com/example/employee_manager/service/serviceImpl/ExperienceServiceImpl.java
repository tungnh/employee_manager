package com.example.employee_manager.service.serviceImpl;

import com.example.employee_manager.domain.Employee;
import com.example.employee_manager.domain.Experience;
import com.example.employee_manager.repository.EmployeeRepository;
import com.example.employee_manager.repository.ExperienceRepository;
import com.example.employee_manager.service.ExperienceService;
import com.example.employee_manager.service.dto.ExperienceDTO;
import com.example.employee_manager.service.mapper.ExperienceMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ExperienceServiceImpl implements ExperienceService {
    private final ExperienceRepository experienceRepository;
    private final EmployeeRepository employeeRepository;
    private final ExperienceMapper experienceMapper;

    public ExperienceServiceImpl(ExperienceRepository experienceRepository, EmployeeRepository employeeRepository, ExperienceMapper experienceMapper) {
        this.experienceRepository = experienceRepository;
        this.employeeRepository = employeeRepository;
        this.experienceMapper = experienceMapper;
    }

    @Override
    public Optional<ExperienceDTO> findById(int id) {
        return experienceRepository.findById(id).map(experienceMapper::toDto);
    }

    @Override
    public Page<ExperienceDTO> findAll(String search, Pageable pageable) {
        if (search == null || search.isEmpty()) {
            return experienceRepository.findAll(pageable).map(experienceMapper::toDto);
        } else {
            return experienceRepository.findByNameContaining(search, pageable).map(experienceMapper::toDto);
        }
    }

    @Override
    public ExperienceDTO save(ExperienceDTO experienceDTO) {
        Experience experience = experienceMapper.toEntity(experienceDTO);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Optional<Employee> employee = employeeRepository.findOneByUserName(userDetails.getUsername());
            if (employee.isPresent()) {
                Employee user = employee.get();
                experience.setCreatedBy(user.getUserName());
                experience.setEmployee(employee.get());
            }
        }
        experience.setCreatedDate(new Date());
        experience = experienceRepository.save(experience);
        return experienceMapper.toDto(experience);
    }

    @Override
    public ExperienceDTO update(ExperienceDTO experienceDTO) {
        Experience experience = experienceMapper.toEntity(experienceDTO);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Optional<Employee> employee = employeeRepository.findOneByUserName(userDetails.getUsername());
            if (employee.isPresent()) {
                Employee user = employee.get();
                experience.setCreatedDate(user.getCreatedDate());
                experience.setCreatedBy(user.getCreatedBy());
                experience.setCreatedBy(user.getUserName());
                experience.setEmployee(employee.get());
            }
        }
        experience.setLastModifiedDate(new Date());
        experience = experienceRepository.save(experience);
        return experienceMapper.toDto(experience);
    }

    @Override
    public void delete(int id) {
        experienceRepository.deleteById(id);
    }
}
