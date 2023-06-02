package com.example.employee_manager.service.serviceImpl;


import com.example.employee_manager.domain.Employee;
import com.example.employee_manager.domain.Skill;
import com.example.employee_manager.repository.EmployeeRepository;
import com.example.employee_manager.repository.SkillRepository;
import com.example.employee_manager.service.SkillService;
import com.example.employee_manager.service.dto.SkillDTO;
import com.example.employee_manager.service.mapper.SkillMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;


@Service
public class SkillServiceImpl implements SkillService {
    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;
    private final EmployeeRepository employeeRepository;

    public SkillServiceImpl(SkillRepository skillRepository, SkillMapper skillMapper, EmployeeRepository employeeRepository) {
        this.skillRepository = skillRepository;
        this.skillMapper = skillMapper;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Optional<SkillDTO> findById(int id) {
        return skillRepository.findById(id).map(skillMapper::toDto);
    }

    @Override
    public Page<SkillDTO> findAll(String search, Pageable pageable) {
        if (search == null || search.isEmpty()) {
            return skillRepository.findAll(pageable).map(skillMapper::toDto);
        } else {
            return skillRepository.findByNameContaining(search, pageable).map(skillMapper::toDto);
        }
    }

    @Override
    public SkillDTO save(SkillDTO skillDTO) {
        Skill skill = skillMapper.toEntity(skillDTO);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Optional<Employee> employee = employeeRepository.findOneByUserName(userDetails.getUsername());
            if (employee.isPresent()) {
                Employee user = employee.get();
                skill.setCreatedBy(user.getUserName());
                skill.setEmployee(employee.get());
            }
        }

        skill.setCreatedDate(new Date());
        skill = skillRepository.save(skill);
        return skillMapper.toDto(skill);
    }

    @Override
    public SkillDTO update(SkillDTO skillDTO) {
        Skill skill = skillMapper.toEntity(skillDTO);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Optional<Employee> employee = employeeRepository.findOneByUserName(userDetails.getUsername());
            if (employee.isPresent()) {
                Employee user = employee.get();
                skill.setCreatedDate(user.getCreatedDate());
                skill.setCreatedBy(user.getCreatedBy());
                skill.setLastModifiedBy(user.getUserName());
                skill.setEmployee(employee.get());
            }
        }

        skill.setLastModifiedDate(new Date());
        skill = skillRepository.save(skill);
        return skillMapper.toDto(skill);
    }

    @Override
    public void delete(int id) {
        skillRepository.deleteById(id);
    }
}
