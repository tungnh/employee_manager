package com.example.employee_manager.service.serviceImpl;

import com.example.employee_manager.domain.Notification;
import com.example.employee_manager.service.NotificationService;
import com.example.employee_manager.service.dto.NotificationDTO;
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
    public Notification save(NotificationDTO notificationDto) {
        return null;
    }

    @Override
    public Notification update(NotificationDTO notificationDto) {
        return null;
    }

    @Override
    public Notification delete(Integer id) {
        return null;
    }
}
