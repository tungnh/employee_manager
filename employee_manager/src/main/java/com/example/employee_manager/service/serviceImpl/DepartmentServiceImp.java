package com.example.employee_manager.service.serviceImpl;

import com.example.employee_manager.domain.Department;
import com.example.employee_manager.service.DepartmentService;
import com.example.employee_manager.service.dto.DepartmentDto;
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
    public Department save(DepartmentDto departmentDto) {
        return null;
    }

    @Override
    public Department update(DepartmentDto departmentDto) {
        return null;
    }

    @Override
    public Department delete(Integer id) {
        return null;
    }
}
