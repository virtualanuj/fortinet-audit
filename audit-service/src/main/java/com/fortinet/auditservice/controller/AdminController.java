package com.fortinet.auditservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fortinet.auditservice.exceptions.AuditMessageNotFoundException;
import com.fortinet.auditservice.model.AuditMessage;
import com.fortinet.auditservice.repository.AuditMessageRepository;
import com.fortinet.auditservice.service.AuditService;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    AuditMessageRepository auditMessageRepository;

    @Autowired
    AuditService auditService;

    @GetMapping("/messages")
    List<AuditMessage> all() {
        LOGGER.info("All current messages for all services is being returned");
        return auditService.all();
    }

    @GetMapping("/message/{id}")
    AuditMessage getById(@PathVariable Long id) {
        LOGGER.info(String.format("Messages for the ID %d will be returned", id));
        return auditMessageRepository.findById(id)
        .orElseThrow( () -> new AuditMessageNotFoundException(id));      
    }
}
