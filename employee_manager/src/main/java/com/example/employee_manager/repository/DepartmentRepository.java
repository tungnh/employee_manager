package com.example.employee_manager.repository;

import com.example.employee_manager.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    List<Department> findByNameContaining(String name);
}