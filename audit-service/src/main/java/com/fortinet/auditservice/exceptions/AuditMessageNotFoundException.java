package com.fortinet.auditservice.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuditMessageNotFoundException extends RuntimeException {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuditMessageNotFoundException.class);


    public AuditMessageNotFoundException(Long id) {
        super(String.format("No Audit Message with id %d found", id));
        LOGGER.info(String.format("No Audit Message with id %d found", id));        
    }
}
