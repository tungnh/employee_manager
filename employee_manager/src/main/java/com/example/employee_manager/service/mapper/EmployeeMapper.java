package com.example.employee_manager.service.mapper;

import com.example.employee_manager.domain.Employee;
import com.example.employee_manager.service.dto.EmployeeDTO;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Component
public class EmployeeMapper implements EntityMapper<EmployeeDTO, Employee>{

    @Override
    public Employee toEntity(EmployeeDTO dto) {
        if (dto == null) {
            return null;
        }

        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setUserName(dto.getUserName());
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setImgUrl(dto.getImgUrl());
        employee.setPassword(dto.getPassword());
        employee.setEmail(dto.getEmail());
        employee.setCitzenId(dto.getCitizenId());
        employee.setBirthday(dto.getBirthday());
        employee.setSex(dto.getSex());
        employee.setNationality(dto.getNationality());
        employee.setNation(dto.getNation());
        employee.setAddress(dto.getAddress());
        employee.setIssuedOn(dto.getIssuedOn());
        employee.setIssueBy(dto.getIssueBy());
        employee.setPhoneNumber(dto.getPhoneNumber());
        employee.setStartWork(dto.getStartWork());
        employee.setEndWork(dto.getEndWork());
        employee.setCoefficientsSalary(dto.getCoefficientsSalary());
        employee.setEducation(dto.getEducation());
        employee.setRole(dto.getRole());
        employee.setAccessToken(dto.getAccessToken());
        employee.setStatus(dto.getStatus());
        employee.setCreatedBy(dto.getCreatedBy());
        employee.setCreatedDate(dto.getCreatedDate());
        employee.setLastModifiedBy(dto.getLastModifiedBy());
        employee.setLastModifiedDate(dto.getLastModifiedDate());

        return employee;
    }

    @Override
    public EmployeeDTO toDto(Employee entity) {
        if (entity == null) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(entity.getId());
        employeeDTO.setUserName(entity.getUserName());
        employeeDTO.setFirstName(entity.getFirstName());
        employeeDTO.setLastName(entity.getLastName());
        employeeDTO.setPassword(entity.getPassword());
        employeeDTO.setImgUrl(entity.getImgUrl());
        employeeDTO.setEmail(entity.getEmail());
        employeeDTO.setPhoneNumber(entity.getPhoneNumber());
        employeeDTO.setCitizenId(entity.getCitzenId());
        employeeDTO.setBirthday(entity.getBirthday());
        employeeDTO.setSex(entity.getSex());
        employeeDTO.setNationality(entity.getNationality());
        employeeDTO.setNation(entity.getNation());
        employeeDTO.setAddress(entity.getAddress());
        employeeDTO.setIssuedOn(entity.getIssuedOn());
        employeeDTO.setIssueBy(entity.getIssueBy());
        employeeDTO.setStartWork(entity.getStartWork());
        employeeDTO.setEndWork(entity.getEndWork());
        employeeDTO.setCoefficientsSalary(entity.getCoefficientsSalary());
        employeeDTO.setEducation(entity.getEducation());
        employeeDTO.setRole(entity.getRole());
        if (entity.getDepartment() != null) {
            employeeDTO.setDepartmenName(entity.getDepartment().getName());
            employeeDTO.setPositionName(entity.getPosition().getName());
        }

        return employeeDTO;
    }

    @Override
    public List<Employee> toEntity(List<EmployeeDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Employee> list = new ArrayList<Employee>( dtoList.size() );
        for ( EmployeeDTO employeeDTO : dtoList ) {
            list.add( toEntity( employeeDTO ) );
        }

        return list;
    }

    @Override
    public List<EmployeeDTO> toDto(List<Employee> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmployeeDTO> list = new ArrayList<EmployeeDTO>( entityList.size() );
        for ( Employee employee : entityList ) {
            list.add( toDto( employee ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Employee entity, EmployeeDTO dto) {

    }
}
