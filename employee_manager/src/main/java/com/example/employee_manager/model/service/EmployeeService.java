package com.example.employee_manager.model.service;

import com.example.employee_manager.dto.request.RegisterRequest;
import com.example.employee_manager.model.entity.Employee;

public interface EmployeeService {
    Employee save(RegisterRequest registerRequest);

}
