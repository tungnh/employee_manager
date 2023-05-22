package com.example.employee_manager.model.service;

import java.util.List;

public interface EmloyeeManagerService<T,V> {
    List<T> findAll();
    T findById(V id);
    T saveOrUpdate(T t);
    T delete(V id);
}
