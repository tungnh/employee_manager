package com.example.employee_manager.service.mapper;

import com.example.employee_manager.domain.Certificate;
import com.example.employee_manager.service.dto.CertificateDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CertificateMapper implements EntityMapper<CertificateDTO, Certificate>{
    @Override
    public Certificate toEntity(CertificateDTO dto) {
        if (dto == null) {
            return null;
        }

        Certificate certificate = new Certificate();
        certificate.setId(dto.getId());
        certificate.setName(dto.getName());
        certificate.setDescription(dto.getDescription());
        certificate.setIssueDate(dto.getIssueDate());
        certificate.setExpirationDate(dto.getExpirationDate());
        certificate.setCreatedBy(dto.getCreatedBy());
        certificate.setCreatedDate(dto.getCreatedDate());
        certificate.setLastModifiedBy(dto.getLastModifiedBy());
        certificate.setLastModifiedDate(dto.getLastModifiedDate());
//        certificate.setEmployee(dto.getEmployeeId());
        return certificate;

    }

    @Override
    public CertificateDTO toDto(Certificate entity) {
        if (entity == null) {
            return null;
        }

        CertificateDTO cetificateDTO = new CertificateDTO();
        cetificateDTO.setId(entity.getId());
        cetificateDTO.setName(entity.getName());
        cetificateDTO.setDescription(entity.getDescription());
        cetificateDTO.setIssueDate(entity.getIssueDate());
        cetificateDTO.setExpirationDate(entity.getExpirationDate());

        return cetificateDTO;
    }

    @Override
    public List<Certificate> toEntity(List<CertificateDTO> dtoList) {
        if (dtoList.isEmpty()) {
            return null;
        }
        List<Certificate> certificateList = new ArrayList<>(dtoList.size());
        for (CertificateDTO cetificateDTO : dtoList) {
            certificateList.add(toEntity(cetificateDTO));
        }
        return certificateList;
    }

    @Override
    public List<CertificateDTO> toDto(List<Certificate> entityList) {
        if (entityList == null) {
            return null;
        }
        List<CertificateDTO> cetificateDTOList = new ArrayList<>(entityList.size());
        for (Certificate certificate : entityList) {
            cetificateDTOList.add(toDto(certificate));
        }
        return cetificateDTOList;
    }

    @Override
    public void partialUpdate(Certificate entity, CertificateDTO dto) {

    }
}
