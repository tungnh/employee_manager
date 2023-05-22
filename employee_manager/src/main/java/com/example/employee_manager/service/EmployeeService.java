package com.example.employee_manager.service;

import com.example.employee_manager.service.dto.request.RegisterRequest;
import com.example.employee_manager.domain.Employee;

public interface EmployeeService {
    Employee save(RegisterRequest registerRequest);

}
