package com.example.employee_manager.model.repository;

import com.example.employee_manager.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findEmployeeByUserName(String username);
    Employee findEmployeeByEmail(String email);
    boolean existsByUserName(String username);
    boolean existsByEmail(String email);
}
