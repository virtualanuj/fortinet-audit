package com.fortinet.auditservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fortinet.auditservice.model.AuditMessage;
import com.fortinet.auditservice.repository.AuditMessageRepository;

@Service
public class AuditService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuditService.class);

    @Autowired
    private AuditMessageRepository auditMessageRepository;

    public List<AuditMessage> all() {
        LOGGER.info("Get all current audit messages from DB");
        return auditMessageRepository.findAll();
    }

    public List<AuditMessage> getByAppName(String appName) {
        LOGGER.info(String.format("Get audit messages for service %s from DB", appName));

        return auditMessageRepository.findByAppName(appName);
    }
}
