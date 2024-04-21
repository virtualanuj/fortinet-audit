package com.fortinet.auditservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fortinet.auditservice.model.AuditMessage;
import com.fortinet.auditservice.model.AuditMessageArchive;
import com.fortinet.auditservice.repository.AuditMessageArchiveRepository;
import com.fortinet.auditservice.repository.AuditMessageRepository;

@Service
public class ArchiveRecordService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArchiveRecordService.class);

    @Autowired
    private AuditMessageRepository auditMessageRepository;
    
    @Autowired
    private AuditMessageArchiveRepository auditMessageArchiveRepository;

    public void moveAuditMessages() {
        LOGGER.info("Moved Audit Messages to Archive");
        List<AuditMessage> messages = auditMessageRepository.findAll();
        for(AuditMessage m :messages) {
            AuditMessageArchive am = new AuditMessageArchive(m.getId(), m.getMessage(), m.getSeverity(), m.getAppName(), m.getCreatedAt());
            auditMessageArchiveRepository.save(am);
        }
        auditMessageRepository.deleteAll();
    }
}
