package com.fortinet.auditservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fortinet.auditservice.exceptions.NotificationNotFoundException;
import com.fortinet.auditservice.model.AuditMessage;
import com.fortinet.auditservice.repository.NotificationRepository;
import com.fortinet.auditservice.service.AuditService;
import com.fortinet.auditservice.service.MicroservicesProducer;

@RestController
@RequestMapping("/api/v1/audit")
public class AuditServiceController {

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    MicroservicesProducer microservicesProducer;

    @Autowired
    AuditService auditService;

    @GetMapping("/messages")
    List<AuditMessage> all() {
        return notificationRepository.findAll();
    }

    @GetMapping("/message/{id}")
    AuditMessage getById(@PathVariable Long id) {
        return notificationRepository.findById(id)
        .orElseThrow( () -> new NotificationNotFoundException(id));      
    }

    @GetMapping("/messages/{appName}")
    List<AuditMessage> getByAppName(@PathVariable String appName) {
        return notificationRepository.findByAppName(appName);
    }
}
