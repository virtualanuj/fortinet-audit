package com.fortinet.auditservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fortinet.auditservice.dto.AuditMessageDTO;
import com.fortinet.auditservice.service.MicroservicesProducer;

@RestController
@RequestMapping("/api/v1/service")
public class MicroserviceController {

    @Autowired
    MicroservicesProducer microservicesProducer;

    @PostMapping("/sendMessage")
    ResponseEntity<String> sendJsonMessage(@RequestBody AuditMessageDTO message) {
        microservicesProducer.sendJsonMessage(message);
        return ResponseEntity.ok("Json Message sent");
    }
}