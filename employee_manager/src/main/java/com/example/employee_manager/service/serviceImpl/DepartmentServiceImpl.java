package com.example.employee_manager.service.serviceImpl;

import com.example.employee_manager.domain.Department;
import com.example.employee_manager.domain.Employee;
import com.example.employee_manager.repository.DepartmentRepository;
import com.example.employee_manager.repository.EmployeeRepository;
import com.example.employee_manager.service.DepartmentService;
import com.example.employee_manager.service.dto.DepartmentDTO;
import com.example.employee_manager.service.dto.ProjectDTO;
import com.example.employee_manager.service.mapper.DepartmentMapper;
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
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentMapper departmentMapper;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    public DepartmentServiceImpl(DepartmentMapper departmentMapper, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentMapper = departmentMapper;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Optional<Employee> optionalEmployee = employeeRepository.findOneByUserName(userDetails.getUsername());
            if (optionalEmployee.isPresent()) {
                Employee user = optionalEmployee.get();
                department.setCreatedBy(user.getUserName());
            }
        }
        department.setCreatedDate(new Date());
        department = departmentRepository.save(department);
        return departmentMapper.toDto(department);
    }

    @Override
    public DepartmentDTO update(DepartmentDTO departmentDTO) {
        Department department = departmentMapper.toEntity(departmentDTO);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Optional<Employee> optionalEmployee = employeeRepository.findOneByUserName(userDetails.getUsername());
            if (optionalEmployee.isPresent()) {
                Employee user = optionalEmployee.get();
                department.setLastModifiedBy(user.getUserName());
            }
        }
        department.setLastModifiedDate(new Date());
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
    public Page<DepartmentDTO> pageAll(String search, Pageable pageable) {
        if (search == null || search.isEmpty()) {
            return departmentRepository.findAll(pageable).map(departmentMapper::toDto);
        } else {
            return departmentRepository.findByNameContaining(search, pageable).map(departmentMapper::toDto);
        }
    }
}