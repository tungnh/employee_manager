package com.example.employee_manager.service;

import com.example.employee_manager.service.dto.CertificateDTO;


import java.util.List;
import java.util.Optional;

public interface CertificateService {
    Optional<CertificateDTO> findById(int id);
    List<CertificateDTO> getAll();
    CertificateDTO save(CertificateDTO certificateDTO);
    CertificateDTO update(CertificateDTO certificateDTO);
    void delete(int id);
}
