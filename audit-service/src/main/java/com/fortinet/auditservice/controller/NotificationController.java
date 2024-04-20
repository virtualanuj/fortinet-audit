package com.fortinet.auditservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fortinet.auditservice.model.Notification;
import com.fortinet.auditservice.repository.NotificationRepository;

@RestController
public class NotificationController {

    @Autowired
    NotificationRepository notificationRepository;

    @GetMapping("/notifications")
    List<Notification> all() {
        return notificationRepository.findAll();
    }

    @GetMapping("/notifications/{id}")
    Notification getById(@PathVariable Long id) {
        return notificationRepository.findById(id).get();
    }

    @PostMapping("/notification")
    Notification creNotification(@RequestBody Notification notification) {
        return notificationRepository.save(notification);
    }

    @DeleteMapping("/notification")
    void delete(@PathVariable Long id) {
        notificationRepository.deleteById(id);
    }
}