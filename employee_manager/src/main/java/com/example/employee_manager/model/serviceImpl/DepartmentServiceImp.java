package com.example.employee_manager.model.serviceImpl;

import com.example.employee_manager.model.entity.Department;
import com.example.employee_manager.model.service.DepartmentService;
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
    public Department saveOrUpdate(Department department) {
        return null;
    }

    @Override
    public Department delete(Integer id) {
        return null;
    }
}
