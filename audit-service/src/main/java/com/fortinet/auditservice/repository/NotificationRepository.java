package com.fortinet.auditservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fortinet.auditservice.model.AuditMessage;

@Repository
public interface NotificationRepository extends JpaRepository<AuditMessage, Long> {
         public List<AuditMessage> findByAppName(String appName);
}
