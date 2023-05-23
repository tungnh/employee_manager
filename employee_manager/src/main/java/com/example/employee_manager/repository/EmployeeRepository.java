package com.example.employee_manager.repository;

import com.example.employee_manager.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Optional<Employee> findOneByUserName(String username);
    Optional<Employee> findOneByEmail(String email);
    boolean existsByUserName(String username);
    boolean existsByEmail(String email);
}
