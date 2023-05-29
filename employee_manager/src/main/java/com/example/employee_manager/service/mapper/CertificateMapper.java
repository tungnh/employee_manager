package com.example.employee_manager.service.mapper;

import com.example.employee_manager.domain.Certificate;
import com.example.employee_manager.service.dto.CetificateDTO;

import java.util.List;

public class CertificateMapper implements EntityMapper<CetificateDTO, Certificate>{
    @Override
    public Certificate toEntity(CetificateDTO dto) {
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
        return certificate;

    }

    @Override
    public CetificateDTO toDto(Certificate entity) {
        return null;
    }

    @Override
    public List<Certificate> toEntity(List<CetificateDTO> dtoList) {
        if (dto == null) {
            return null;
        }

        CetificateDTO cetificateDTO = new CetificateDTO();
        return null;
    }

    @Override
    public List<CetificateDTO> toDto(List<Certificate> entityList) {
        return null;
    }

    @Override
    public void partialUpdate(Certificate entity, CetificateDTO dto) {

    }
}
