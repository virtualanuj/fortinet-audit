package com.fortinet.auditservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(MicroserviceController.class);

    @Autowired
    MicroservicesProducer microservicesProducer;

    @PostMapping("/sendMessage")
    ResponseEntity<String> sendJsonMessage(@RequestBody AuditMessageDTO message) {
        LOGGER.info(String.format("Sending Message ** %s ** to the queue", message.toString()));
        microservicesProducer.sendJsonMessage(message);
        return ResponseEntity.ok("Json Message sent");
    }
}