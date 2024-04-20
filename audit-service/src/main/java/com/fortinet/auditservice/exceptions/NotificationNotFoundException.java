package com.fortinet.auditservice.exceptions;

public class NotificationNotFoundException extends RuntimeException {

    public NotificationNotFoundException(Long id) {
        super("No Notification with id " + id);
    }
}
