package com.fortinet.auditservice.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fortinet.auditservice.dto.AuditMessageDTO;

@Service
public class MicroservicesProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;
        
    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

    public void sendJsonMessage(AuditMessageDTO message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

}
