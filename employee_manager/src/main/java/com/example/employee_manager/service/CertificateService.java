package com.example.employee_manager.service;

import com.example.employee_manager.service.dto.CertificateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

public interface CertificateService {
    Optional<CertificateDTO> findById(int id);
    List<CertificateDTO> findAll();
    Page<CertificateDTO> pageAll(Pageable pageable);
    CertificateDTO save(CertificateDTO certificateDTO);
    CertificateDTO update(CertificateDTO certificateDTO);
    void delete(int id);
}
