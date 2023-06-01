package com.example.employee_manager.service.serviceImpl;

import com.example.employee_manager.domain.Employee;
import com.example.employee_manager.domain.Position;
import com.example.employee_manager.repository.EmployeeRepository;
import com.example.employee_manager.repository.PositionRepository;
import com.example.employee_manager.service.PositionService;
import com.example.employee_manager.service.dto.PositionDTO;
import com.example.employee_manager.service.mapper.PositionMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
public class PositionServiceImpl implements PositionService {
    public final PositionRepository positionRepository;
    public final PositionMapper positionMapper;
    public final EmployeeRepository employeeRepository;

    public PositionServiceImpl(PositionRepository positionRepository, PositionMapper positionMapper, EmployeeRepository employeeRepository) {
        this.positionRepository = positionRepository;
        this.positionMapper = positionMapper;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Optional<PositionDTO> findById(int id) {
        return positionRepository.findById(id).map(positionMapper::toDto);
    }

    @Override
    public List<PositionDTO> getAll() {
        return positionMapper.toDto(positionRepository.findAll());
    }

    @Override
    public PositionDTO save(PositionDTO positionDto) {
        Position position = positionMapper.toEntity(positionDto);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Optional<Employee> optionalEmployee = employeeRepository.findOneByUserName(userDetails.getUsername());
            if (optionalEmployee.isPresent()) {
                Employee user = optionalEmployee.get();
                position.setCreatedBy(user.getUserName());
            }
        }
        position.setCreatedDate(new Date());
        position = positionRepository.save(position);
        return positionMapper.toDto(position);
    }

    @Override
    public PositionDTO update(PositionDTO positionDto) {
        Position position = positionMapper.toEntity(positionDto);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Optional<Employee> optionalEmployee = employeeRepository.findOneByUserName(userDetails.getUsername());
            if (optionalEmployee.isPresent()) {
                Employee user = optionalEmployee.get();
                position.setLastModifiedBy(user.getUserName());
            }
        }
        position.setLastModifiedDate(new Date());
        position.setId(positionDto.getId());
        positionRepository.save(position);
        PositionDTO positionDTO1 = positionMapper.toDto(position);
        return positionDTO1;
    }

    @Override
    public void delete(int id) {
        positionRepository.deleteById(id);
    }

    @Override
    public Page<PositionDTO> pageAll(String search, Pageable pageable) {
        if (search == null || search.isEmpty()) {
            return positionRepository.findAll(pageable).map(positionMapper::toDto);
        } else {
            return positionRepository.findByNameContaining(search, pageable).map(positionMapper::toDto);
        }
    }


}