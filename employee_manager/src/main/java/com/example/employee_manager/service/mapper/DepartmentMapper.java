package com.example.employee_manager.service.mapper;

import com.example.employee_manager.domain.Department;
import com.example.employee_manager.service.dto.DepartmentDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DepartmentMapper implements EntityMapper<DepartmentDTO, Department> {
    @Override
    public Department toEntity(DepartmentDTO dto) {
        if (dto == null) {
            return null;
        }
        Department department = new Department();
        department.setName(dto.getName());
        department.setLeaderId(dto.getLeaderId());
        department.setParentId(dto.getParentId());
        department.setSubLeaderId(dto.getSubLeaderId());
        department.setDescription(dto.getDescription());
        department.setStatus(dto.getStatus());
        department.setCreatedBy(dto.getCreatedBy());
        department.setCreatedDate(dto.getCreatedDate());
        department.setLastModifiedBy(dto.getLastModifiedBy());
        department.setLastModifiedDate(dto.getLastModifiedDate());
        return department;
    }

    @Override
    public DepartmentDTO toDto(Department entity) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(entity.getId());
        departmentDTO.setName(entity.getName());
        departmentDTO.setLeaderId(entity.getLeaderId());
        departmentDTO.setParentId(entity.getParentId());
        departmentDTO.setSubLeaderId(entity.getSubLeaderId());
        departmentDTO.setDescription(entity.getDescription());
        return departmentDTO;
    }

    @Override
    public List<Department> toEntity(List<DepartmentDTO> dtoList) {
        if (dtoList.isEmpty()) {
            return null;
        }
        List<Department> departmentList = new ArrayList<>(dtoList.size());
        for (DepartmentDTO departmentDTO : dtoList) {
            departmentList.add(toEntity(departmentDTO));
        }
        return departmentList;
    }

    @Override
    public List<DepartmentDTO> toDto(List<Department> entityList) {

        if (entityList == null) {
            return null;
        }
        List<DepartmentDTO> departmentDTOList = new ArrayList<>(entityList.size());
        for (Department department : entityList) {
            departmentDTOList.add(toDto(department));
        }
        return departmentDTOList;
    }

    @Override
    public void partialUpdate(Department entity, DepartmentDTO dto) {

    }
}
