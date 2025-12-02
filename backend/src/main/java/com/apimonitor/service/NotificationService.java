package com.apimonitor.service;

import com.apimonitor.entity.AlertEvent;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendNotification(AlertEvent event) {
        // Stub: send email or webhook
        System.out.println("Alert triggered: " + event.getMessage());
    }
}