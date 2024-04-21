package com.fortinet.auditservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fortinet.auditservice.model.AuditMessage;
import com.fortinet.auditservice.repository.AuditMessageRepository;

@Service
public class AuditService {

    @Autowired
    private AuditMessageRepository auditMessageRepository;

    public List<AuditMessage> all() {
        return auditMessageRepository.findAll();
    }

    public List<AuditMessage> getByAppName(String appName) {
        return auditMessageRepository.findByAppName(appName);
    }
}
