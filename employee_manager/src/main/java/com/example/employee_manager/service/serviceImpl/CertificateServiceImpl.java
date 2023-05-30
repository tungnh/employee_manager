package com.example.employee_manager.service.serviceImpl;


import com.example.employee_manager.domain.Certificate;
import com.example.employee_manager.domain.Employee;
import com.example.employee_manager.repository.CertificateRepository;
import com.example.employee_manager.repository.EmployeeRepository;
import com.example.employee_manager.repository.ExperienceRepository;
import com.example.employee_manager.service.CertificateService;
import com.example.employee_manager.service.dto.CertificateDTO;
import com.example.employee_manager.service.mapper.CertificateMapper;
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
public class CertificateServiceImpl implements CertificateService {
    private final CertificateRepository certificateRepository;
    private final CertificateMapper certificateMapper;
    private final EmployeeRepository employeeRepository;

    public CertificateServiceImpl(CertificateRepository certificateRepository, CertificateMapper certificateMapper, EmployeeRepository employeeRepository,
                                  ExperienceRepository experienceRepository) {
        this.certificateRepository = certificateRepository;
        this.certificateMapper = certificateMapper;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Optional<CertificateDTO> findById(int id) {
        Optional<Certificate> certificateOptional = certificateRepository.findById(id);
        if (certificateOptional.isPresent()) {
            Certificate certificate = certificateOptional.get();
            CertificateDTO cetificateDTO = certificateMapper.toDto(certificate);
            return Optional.of(cetificateDTO);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<CertificateDTO> findAll() {
        return certificateMapper.toDto(certificateRepository.findAll());
    }

    @Override
    public Page<CertificateDTO> pageAll(Pageable pageable) {
        return certificateRepository.findAll(pageable).map(certificateMapper::toDto);
    }

    @Override
    public CertificateDTO save(CertificateDTO cetificateDTO) {
        Certificate certificate = certificateMapper.toEntity(cetificateDTO);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Optional<Employee> employee = employeeRepository.findOneByUserName(userDetails.getUsername());
            if (employee.isPresent()) {
                Employee user = employee.get();
                certificate.setCreatedBy(user.getUserName());
                certificate.setEmployee(employee.get());
            }
        }

        certificate.setCreatedDate(new Date());
        certificate = certificateRepository.save(certificate);
        return certificateMapper.toDto(certificate);
    }

    @Override
    public CertificateDTO update(CertificateDTO cetificateDTO) {
        Certificate certificate = certificateMapper.toEntity(cetificateDTO);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Optional<Employee> employee = employeeRepository.findOneByUserName(userDetails.getUsername());
            if (employee.isPresent()) {
                Employee user = employee.get();
                certificate.setLastModifiedBy(user.getUserName());
                certificate.setEmployee(employee.get());
            }
        }

        certificate.setLastModifiedDate(new Date());
        certificate = certificateRepository.save(certificate);
        return certificateMapper.toDto(certificate);
    }

    @Override
    public void delete(int id) {
        certificateRepository.deleteById(id);
    }

    @Override
    public List<CertificateDTO> searchByName(String name) {
        return certificateMapper.toDto(certificateRepository.findByNameContaining(name));
    }

}
