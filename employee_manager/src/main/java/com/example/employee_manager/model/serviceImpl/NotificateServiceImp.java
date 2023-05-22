package com.example.employee_manager_pr.model.serviceImpl;

import com.example.employee_manager_pr.model.entity.Notification;
import com.example.employee_manager_pr.model.service.NotificationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificateServiceImp implements NotificationService {
    @Override
    public List<Notification> findAll() {
        return null;
    }

    @Override
    public Notification findById(Integer id) {
        return null;
    }

    @Override
    public Notification saveOrUpdate(Notification notification) {
        return null;
    }

    @Override
    public Notification delete(Integer id) {
        return null;
    }
}
