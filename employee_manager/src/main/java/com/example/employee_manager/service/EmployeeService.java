package com.example.employee_manager.service;

import com.example.employee_manager.service.dto.EmployeeDto;
import com.example.employee_manager.domain.Employee;

public interface EmployeeService extends EmloyeeManagerService<Employee,EmployeeDto,Integer>{
    Employee save(EmployeeDto register);

}
