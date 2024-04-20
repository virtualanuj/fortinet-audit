package com.fortinet.auditservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fortinet.auditservice.model.Notification;
import com.fortinet.auditservice.repository.NotificationRepository;

@Service
public class AuditService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getMessagesByAppName(String appName) {
        return notificationRepository.findByAppName(appName);
    }

}
