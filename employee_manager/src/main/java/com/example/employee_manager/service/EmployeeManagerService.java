package com.example.employee_manager.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EmployeeManagerService<T,V> {
    Page<T> findAll(Pageable pageable);
    Optional<T> findOne(V id);
    T save(T t);
    T update(T t);
    void delete(V id);
}
