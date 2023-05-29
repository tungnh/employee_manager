package com.example.employee_manager.service;

import com.example.employee_manager.domain.Certificate;
import com.example.employee_manager.service.dto.CetificateDTO;
import com.example.employee_manager.service.dto.DepartmentDTO;

import java.util.List;
import java.util.Optional;

public interface CertificateService {
    Optional<CetificateDTO> findById(int id);
    List<CetificateDTO> getAll();
    CetificateDTO save(CetificateDTO cetificateDTO);
    CetificateDTO update(CetificateDTO cetificateDTO);
    void delete(int id);
}
