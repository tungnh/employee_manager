package com.example.employee_manager.service.mapper;

import com.example.employee_manager.domain.Certificate;
import com.example.employee_manager.domain.Department;
import com.example.employee_manager.service.dto.CetificateDTO;
import com.example.employee_manager.service.dto.DepartmentDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
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
        if (entity == null) {
            return null;
        }

        CetificateDTO cetificateDTO = new CetificateDTO();
        cetificateDTO.setId(entity.getId());
        cetificateDTO.setName(entity.getName());
        cetificateDTO.setDescription(entity.getDescription());
        cetificateDTO.setIssueDate(entity.getIssueDate());
        cetificateDTO.setExpirationDate(entity.getExpirationDate());

        return cetificateDTO;
    }

    @Override
    public List<Certificate> toEntity(List<CetificateDTO> dtoList) {
        if (dtoList.isEmpty()) {
            return null;
        }
        List<Certificate> certificateList = new ArrayList<>(dtoList.size());
        for (CetificateDTO cetificateDTO : dtoList) {
            certificateList.add(toEntity(cetificateDTO));
        }
        return certificateList;
    }

    @Override
    public List<CetificateDTO> toDto(List<Certificate> entityList) {
        if (entityList == null) {
            return null;
        }
        List<CetificateDTO> cetificateDTOList = new ArrayList<>(entityList.size());
        for (Certificate certificate : entityList) {
            cetificateDTOList.add(toDto(certificate));
        }
        return cetificateDTOList;
    }

    @Override
    public void partialUpdate(Certificate entity, CetificateDTO dto) {

    }
}
