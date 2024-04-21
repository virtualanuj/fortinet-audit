package com.fortinet.auditservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fortinet.auditservice.exceptions.NotificationNotFoundException;
import com.fortinet.auditservice.model.AuditMessage;
import com.fortinet.auditservice.repository.AuditMessageRepository;
import com.fortinet.auditservice.service.AuditService;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    AuditMessageRepository auditMessageRepository;

    @Autowired
    AuditService auditService;

    @GetMapping("/messages")
    List<AuditMessage> all() {
        return auditService.all();
    }

    @GetMapping("/message/{id}")
    AuditMessage getById(@PathVariable Long id) {
        return auditMessageRepository.findById(id)
        .orElseThrow( () -> new NotificationNotFoundException(id));      
    }
}
