package com.fortinet.auditservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fortinet.auditservice.dto.AuditMessageDTO;

@Service
public class MicroservicesProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MicroservicesProducer.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchange;
        
    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendJsonMessage(AuditMessageDTO message) {
        LOGGER.info(String.format("Sending message %s to queue", message.toString()));
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

}
