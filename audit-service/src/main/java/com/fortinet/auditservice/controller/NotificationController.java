package com.fortinet.auditservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fortinet.auditservice.dto.AuditMessage;
import com.fortinet.auditservice.exceptions.NotificationNotFoundException;
import com.fortinet.auditservice.model.Notification;
import com.fortinet.auditservice.repository.NotificationRepository;
import com.fortinet.auditservice.service.AuditService;
import com.fortinet.auditservice.service.MicroservicesProducer;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class NotificationController {

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    MicroservicesProducer microservicesProducer;

    @Autowired
    AuditService auditService;

    @GetMapping("/notifications")
    List<Notification> all() {
        return notificationRepository.findAll();
    }

    @GetMapping("/notifications/{id}")
    Notification getById(@PathVariable Long id) {
        return notificationRepository.findById(id)
        .orElseThrow( () -> new NotificationNotFoundException(id));      
    }

    @GetMapping("/notifications/service/{appName}")
    List<Notification> getByAppName(@PathVariable String appName) {
        return notificationRepository.findByAppName(appName);
    }

    @PostMapping("/notification")
    Notification creNotification(@Valid @RequestBody Notification notification) {
        return notificationRepository.save(notification);
    }

    @DeleteMapping("/notification/{id}")
    void delete(@PathVariable Long id) {
        notificationRepository.deleteById(id);
    }

    @PostMapping("/sendMessage")
    ResponseEntity<String> sendJsonMessage(@RequestBody AuditMessage message) {
        microservicesProducer.sendJsonMessage(message);
        return ResponseEntity.ok("Json Message sent");
    }
}
