package com.example.employee_manager.service.serviceImpl;

import com.example.employee_manager.service.dto.EmployeeDTO;
import com.example.employee_manager.domain.Employee;
import com.example.employee_manager.repository.EmployeeRepository;
import com.example.employee_manager.service.EmployeeService;
import com.example.employee_manager.service.mapper.EmployeeMapper;
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

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<EmployeeDTO> findAll() {
        return employeeMapper.toDto(employeeRepository.findAll());
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
            }
        }
        employee.setLastModifiedDate(new Date());
        employee = employeeRepository.save(employee);
        return employeeMapper.toDto(employee);

    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
