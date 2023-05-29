package com.example.employee_manager.service.serviceImpl;

import com.example.employee_manager.domain.Department;
import com.example.employee_manager.domain.Position;
import com.example.employee_manager.repository.DepartmentRepository;
import com.example.employee_manager.service.DepartmentService;
import com.example.employee_manager.service.dto.DepartmentDTO;
import com.example.employee_manager.service.dto.PositionDTO;
import com.example.employee_manager.service.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepartmentServiceImp implements DepartmentService {

    private final DepartmentMapper departmentMapper;
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImp(DepartmentMapper departmentMapper, DepartmentRepository departmentRepository) {
        this.departmentMapper = departmentMapper;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Optional<DepartmentDTO> findById(int id) {
     return departmentRepository.findById(id).map(departmentMapper::toDto);
    }

    @Override
    public List<DepartmentDTO> getAll() {
        return departmentMapper.toDto(departmentRepository.findAll());
    }

    @Override
    public DepartmentDTO save(DepartmentDTO departmentDTO) {

        Department department = departmentMapper.toEntity(departmentDTO);
        department = departmentRepository.save(department);
        return departmentMapper.toDto(department);
    }

    @Override
    public DepartmentDTO update(DepartmentDTO departmentDTO) {
        Department department =departmentMapper.toEntity(departmentDTO);
        department.setId(department.getId());
        departmentRepository.save(department);
        DepartmentDTO departmentDTO1 = departmentMapper.toDto(department);
        return departmentDTO1;
    }

    @Override
    public void delete(int id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public List<DepartmentDTO> searchByName(String name) {
        return departmentMapper.toDto(departmentRepository.findByNameContaining(name));
    }
}
