package com.example.employee_manager.service.serviceImpl;

import com.example.employee_manager.service.dto.EmployeeDTO;
import com.example.employee_manager.domain.Employee;
import com.example.employee_manager.repository.EmployeeRepository;
import com.example.employee_manager.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {


    @Override
    public Page<EmployeeDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<EmployeeDTO> findOne(Integer id) {
        return Optional.empty();
    }

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        return null;
    }

    @Override
    public EmployeeDTO update(EmployeeDTO employeeDTO) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
