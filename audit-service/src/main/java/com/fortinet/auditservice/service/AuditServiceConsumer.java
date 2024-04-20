package com.fortinet.auditservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class AuditServiceConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuditServiceConsumer.class);

    @RabbitListener( queues  = {"${rabbitmq.queue.name}"})
    public void consume(String message) {
        LOGGER.info(String.format("Received message -> %s", message));
    }

}
