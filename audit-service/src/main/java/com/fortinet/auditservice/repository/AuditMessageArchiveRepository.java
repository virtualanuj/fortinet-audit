package com.fortinet.auditservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fortinet.auditservice.model.AuditMessageArchive;

@Repository
public interface AuditMessageArchiveRepository extends JpaRepository<AuditMessageArchive, Long> {
}

