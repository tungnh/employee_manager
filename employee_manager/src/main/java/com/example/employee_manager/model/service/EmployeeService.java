package com.example.employee_manager_pr.model.service;

import com.example.employee_manager_pr.dto.request.RegisterRequest;
import com.example.employee_manager_pr.model.entity.Employee;

public interface EmployeeService {
    Employee save(RegisterRequest registerRequest);

}
