package com.fortinet.auditservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fortinet.auditservice.model.AuditMessage;
import com.fortinet.auditservice.service.AuditService;

@RestController
@RequestMapping("/api/v1/audit")
public class AuditServiceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuditServiceController.class);

    @Autowired
    AuditService auditService;

    @GetMapping("/messages/{appName}")
    List<AuditMessage> getByAppName(@PathVariable String appName) {
        LOGGER.info(String.format("Messages for the Service %s is being returned", appName));
        return auditService.getByAppName(appName);
    }
}
