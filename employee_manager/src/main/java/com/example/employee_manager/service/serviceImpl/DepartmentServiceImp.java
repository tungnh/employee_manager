package com.example.employee_manager.service.serviceImpl;

import com.example.employee_manager.domain.Department;
import com.example.employee_manager.service.DepartmentService;
import com.example.employee_manager.service.dto.DepartmentDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImp implements DepartmentService {
    @Override
    public List<Department> findAll() {
        return null;
    }

    @Override
    public Department findById(Integer id) {
        return null;
    }

    @Override
    public Department save(DepartmentDTO departmentDto) {
        return null;
    }

    @Override
    public Department update(DepartmentDTO departmentDto) {
        return null;
    }

    @Override
    public Department delete(Integer id) {
        return null;
    }
}
