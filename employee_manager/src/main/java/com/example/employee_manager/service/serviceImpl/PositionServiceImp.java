package com.example.employee_manager.service.serviceImpl;

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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class PositionServiceImp implements PositionService {

    public final PositionRepository positionRepository;
    public final PositionMapper positionMapper;
    public final EmployeeRepository employeeRepository;

    public PositionServiceImp(PositionRepository positionRepository, PositionMapper positionMapper, EmployeeRepository employeeRepository) {
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
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication.getPrincipal() instanceof UserDetails) {
//            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//            Optional<Employee> optionalEmployee = employeeRepository.findOneByUserName(userDetails.getUsername());
//            if (optionalEmployee.isPresent()) {
//                Employee user = optionalEmployee.get();
//                employee.setCreatedBy(user.getUserName());
//            }
//        }
//        employee.setCreatedDate(new Date());
        Position position = positionMapper.toEntity(positionDto);
        position = positionRepository.save(position);
        return positionMapper.toDto(position);
    }

    @Override
    public PositionDTO update(PositionDTO positionDto) {
        Position position = positionMapper.toEntity(positionDto);
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
    public List<PositionDTO> searchByName(String name) {

        return positionMapper.toDto(positionRepository.findByNameContaining(name));
    }

    @Override
    public List<PositionDTO> getPagingAndSort(int page) {
        Sort.Order order;
        order = new Sort.Order(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, 5, Sort.by(order));
        return positionMapper.toDto(positionRepository.findAll(pageable).getContent());
    }
}
