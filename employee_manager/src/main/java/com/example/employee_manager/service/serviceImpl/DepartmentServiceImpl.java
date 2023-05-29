package com.example.employee_manager.service.serviceImpl;

import com.example.employee_manager.domain.Department;
import com.example.employee_manager.repository.DepartmentRepository;
import com.example.employee_manager.service.DepartmentService;
import com.example.employee_manager.service.dto.DepartmentDTO;
import com.example.employee_manager.service.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentMapper departmentMapper;
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentMapper departmentMapper, DepartmentRepository departmentRepository) {
        this.departmentMapper = departmentMapper;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Optional<DepartmentDTO> findById(int id) {
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        if (departmentOptional.isPresent()) {
            Department department = departmentOptional.get();
            DepartmentDTO departmentDTO = departmentMapper.toDto(department);
            return Optional.of(departmentDTO);
        } else {
            return Optional.empty();
        }
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
        return null;
    }

    @Override
    public void delete(int id) {
        departmentRepository.deleteById(id);
    }
}

