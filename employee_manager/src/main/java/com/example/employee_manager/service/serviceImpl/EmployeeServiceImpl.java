package com.example.employee_manager.service.serviceImpl;

import com.example.employee_manager.domain.Department;
import com.example.employee_manager.domain.Position;
import com.example.employee_manager.repository.CertificateRepository;
import com.example.employee_manager.repository.DepartmentRepository;
import com.example.employee_manager.repository.PositionRepository;
import com.example.employee_manager.service.dto.EmployeeDTO;
import com.example.employee_manager.domain.Employee;
import com.example.employee_manager.repository.EmployeeRepository;
import com.example.employee_manager.service.EmployeeService;
import com.example.employee_manager.service.mapper.EmployeeMapper;
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
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final DepartmentRepository departmentRepository;
    private final PositionRepository positionRepository;
    private final CertificateRepository certificateRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper, DepartmentRepository departmentRepository, PositionRepository positionRepository, CertificateRepository certificateRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.departmentRepository = departmentRepository;
        this.positionRepository = positionRepository;
        this.certificateRepository = certificateRepository;
    }

    @Override
    public Page<EmployeeDTO> findAll(String search, Pageable pageable) {
        if (search == null || search.isEmpty()) {
            return employeeRepository.findAll(pageable).map(employeeMapper::toDto);
        } else {
            return employeeRepository.findByFirstNameOrLastNameContaining(search, pageable).map(employeeMapper::toDto);
        }
    }

    @Override
    public Optional<EmployeeDTO> findById(int id) {
        return employeeRepository.findById(id).map(employeeMapper::toDto);
    }

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEntity(employeeDTO);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Optional<Employee> optionalEmployee = employeeRepository.findOneByUserName(userDetails.getUsername());
            if (optionalEmployee.isPresent()) {
                Employee user = optionalEmployee.get();
                employee.setCreatedBy(user.getUserName());
            }
        }
        employee.setDepartment(departmentRepository.findById(employeeDTO.getDepartmentId()).get());
        employee.setPosition(positionRepository.findById(employeeDTO.getPositionId()).get());
        employee.setCreatedDate(new Date());
        employee = employeeRepository.save(employee);
        return employeeMapper.toDto(employee);
    }

    @Override
    public EmployeeDTO update(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEntity(employeeDTO);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Optional<Employee> optionalEmployee = employeeRepository.findOneByUserName(userDetails.getUsername());
            if (optionalEmployee.isPresent()) {
                Employee user = optionalEmployee.get();
                employee.setLastModifiedBy(user.getUserName());
                employee.setCreatedBy(user.getCreatedBy());
                employee.setCreatedDate(user.getCreatedDate());
            }
        }
        employee.setDepartment(departmentRepository.findById(employeeDTO.getDepartmentId()).get());
        employee.setPosition(positionRepository.findById(employeeDTO.getPositionId()).get());
        employee.setLastModifiedDate(new Date());
        employee = employeeRepository.save(employee);
        return employeeMapper.toDto(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
