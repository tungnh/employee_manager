package com.example.employee_manager.service;

import java.util.List;

public interface EmloyeeManagerService<T,D,V> {
    List<T> findAll();
    T findById(V id);
    T save(D d);
    T update(D d);
    T delete(V id);
}
