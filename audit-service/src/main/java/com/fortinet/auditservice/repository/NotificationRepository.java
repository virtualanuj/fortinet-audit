package com.fortinet.auditservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fortinet.auditservice.model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

}