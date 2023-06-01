package com.example.employee_manager.repository;

import com.example.employee_manager.domain.Certificate;
import com.example.employee_manager.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Optional<Employee> findOneByUserName(String username);
    Optional<Employee> findOneByEmail(String email);
    boolean existsByUserName(String username);
    boolean existsByEmail(String email);
    @Query(value = "select * from employee where firtName like '%' or lastName like '%'",nativeQuery = true)
    Page<Employee> findByFirstNameOrLastNameContaining(String search, Pageable pageable);
}
