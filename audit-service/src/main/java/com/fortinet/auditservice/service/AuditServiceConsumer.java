package com.fortinet.auditservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fortinet.auditservice.dto.AuditMessageDTO;
import com.fortinet.auditservice.model.AuditMessage;
import com.fortinet.auditservice.repository.AuditMessageRepository;

@Service
public class AuditServiceConsumer {

    @Autowired
    private AuditMessageRepository auditMessageRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(AuditServiceConsumer.class);

    @RabbitListener( queues  = {"${rabbitmq.queue.name}"})
    public void consume(AuditMessageDTO message) {
        LOGGER.info(String.format("Received message -> %s", message.toString()));
        AuditMessage n = new AuditMessage();
        n.setAppName(message.getAppName());
        n.setMessage(message.getMessage());
        n.setSeverity(message.getSeverity()); 
        auditMessageRepository.save(n);
        LOGGER.info(String.format("Message saved to DB", n.toString()));
    }


}
