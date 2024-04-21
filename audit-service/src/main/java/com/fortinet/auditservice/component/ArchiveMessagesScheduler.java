package com.fortinet.auditservice.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fortinet.auditservice.service.ArchiveRecordService;

@Component
public class ArchiveMessagesScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArchiveMessagesScheduler.class);

    @Autowired
    private ArchiveRecordService archiveRecordService;

    @Value("${auditlog.rotation.window}")
    private int window;

    @Scheduled(fixedDelay = 3000000, initialDelay = 120000)
    public void runArchiveRecordsService() {
        LOGGER.info("Running Scheduled Archive message Task " + window);
        archiveRecordService.moveAuditMessages();;
    }
}
