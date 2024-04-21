package com.fortinet.auditservice.dto;

import lombok.Data;

@Data
public class AuditMessageDTO {

    private int id;

    private String message;

    private int Severity;

    private String appName;
}
