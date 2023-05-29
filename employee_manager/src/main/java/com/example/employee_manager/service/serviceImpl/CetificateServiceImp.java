package com.example.employee_manager.service.serviceImpl;

import com.example.employee_manager.domain.Certificate;
import com.example.employee_manager.domain.Department;
import com.example.employee_manager.domain.Employee;
import com.example.employee_manager.repository.CertificateRepository;
import com.example.employee_manager.repository.EmployeeRepository;
import com.example.employee_manager.service.CertificateService;
import com.example.employee_manager.service.dto.CetificateDTO;
import com.example.employee_manager.service.dto.DepartmentDTO;
import com.example.employee_manager.service.mapper.CertificateMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CetificateServiceImp implements CertificateService {
    private final CertificateRepository certificateRepository;
    private final CertificateMapper certificateMapper;
    private final EmployeeRepository employeeRepository;

    public CetificateServiceImp(CertificateRepository certificateRepository, CertificateMapper certificateMapper, EmployeeRepository employeeRepository) {
        this.certificateRepository = certificateRepository;
        this.certificateMapper = certificateMapper;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Optional<CetificateDTO> findById(int id) {
        Optional<Certificate> certificateOptional = certificateRepository.findById(id);
        if (certificateOptional.isPresent()) {
            Certificate certificate = certificateOptional.get();
            CetificateDTO cetificateDTO = certificateMapper.toDto(certificate);
            return Optional.of(cetificateDTO);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<CetificateDTO> getAll() {
        return certificateMapper.toDto(certificateRepository.findAll());
    }

    @Override
    public CetificateDTO save(CetificateDTO cetificateDTO) {
        Certificate certificate = certificateMapper.toEntity(cetificateDTO);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Optional<Employee> employee = employeeRepository.findOneByUserName(userDetails.getUsername());
            if (employee.isPresent()) {
                Employee user = employee.get();
                cetificateDTO.setCreatedBy(user.getUserName());
            }
        }
        certificate.setCreatedDate(new Date());
        certificate = certificateRepository.save(certificate);
        return certificateMapper.toDto(certificate);
    }

    @Override
    public CetificateDTO update(CetificateDTO cetificateDTO) {
        Certificate certificate = certificateMapper.toEntity(cetificateDTO);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Optional<Employee> employee = employeeRepository.findOneByUserName(userDetails.getUsername());
            if (employee.isPresent()) {
                Employee user = employee.get();
                cetificateDTO.setLastModifiedBy(user.getUserName());
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
}
