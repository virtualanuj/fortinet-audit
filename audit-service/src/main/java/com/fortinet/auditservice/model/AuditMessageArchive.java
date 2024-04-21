package com.fortinet.auditservice.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuditMessageArchive {

    @Id
    private Long id;
 
    private String message;

    private int Severity;

    private String appName;

    private LocalDateTime createdAt;
}
