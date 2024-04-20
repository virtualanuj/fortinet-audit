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

import com.fortinet.auditservice.exceptions.NotificationNotFoundException;
import com.fortinet.auditservice.model.Notification;
import com.fortinet.auditservice.repository.NotificationRepository;
import com.fortinet.auditservice.service.MicroservicesProducer;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class NotificationController {

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    MicroservicesProducer microservicesProducer;

    @GetMapping("/notifications")
    List<Notification> all() {
        return notificationRepository.findAll();
    }

    @GetMapping("/notifications/{id}")
    Notification getById(@PathVariable Long id) {
        return notificationRepository.findById(id)
        .orElseThrow( () -> new NotificationNotFoundException(id));      
    }

    @PostMapping("/notification")
    Notification creNotification(@Valid @RequestBody Notification notification) {
        return notificationRepository.save(notification);
    }

    @DeleteMapping("/notification/{id}")
    void delete(@PathVariable Long id) {
        notificationRepository.deleteById(id);
    }

    @GetMapping("/sendMessage/{message}")
    ResponseEntity<String> sendMessage(@PathVariable String message) {
        microservicesProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent");
    }
}
