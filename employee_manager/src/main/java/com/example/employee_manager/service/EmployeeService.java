package com.example.employee_manager.service;

import com.example.employee_manager.domain.Certificate;
import com.example.employee_manager.domain.Experience;
import com.example.employee_manager.domain.Skill;
import com.example.employee_manager.service.dto.EmployeeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<EmployeeDTO> findAll();
    Page<EmployeeDTO> findAll(String search, Pageable pageable);
    Optional<EmployeeDTO> findById(int id);
    EmployeeDTO save(EmployeeDTO employeeDTO);
    EmployeeDTO update(EmployeeDTO employeeDTO);
    void delete(int id);
    List<Skill> getSkillByEmployeeId(int id);
    List<Certificate> getCertificateByEmployeeId(int id);
    List<Experience> getExceptionByEmployeeId(int id);
}
