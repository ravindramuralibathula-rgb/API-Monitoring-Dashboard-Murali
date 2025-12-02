package com.apimonitor.service;

import com.apimonitor.entity.AlertEvent;
import com.apimonitor.entity.AlertRule;
import com.apimonitor.entity.HealthCheckLog;
import com.apimonitor.repository.AlertEventRepository;
import com.apimonitor.repository.AlertRuleRepository;
import com.apimonitor.repository.HealthCheckLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlertEngine {

    private final AlertRuleRepository alertRuleRepository;
    private final HealthCheckLogRepository healthCheckLogRepository;
    private final AlertEventRepository alertEventRepository;
    private final NotificationService notificationService;

    public AlertEngine(AlertRuleRepository alertRuleRepository, HealthCheckLogRepository healthCheckLogRepository,
                       AlertEventRepository alertEventRepository, NotificationService notificationService) {
        this.alertRuleRepository = alertRuleRepository;
        this.healthCheckLogRepository = healthCheckLogRepository;
        this.alertEventRepository = alertEventRepository;
        this.notificationService = notificationService;
    }

    public void checkAlerts() {
        List<AlertRule> rules = alertRuleRepository.findAll();
        for (AlertRule rule : rules) {
            if (rule.getEnabled()) {
                evaluateRule(rule);
            }
        }
    }

    private void evaluateRule(AlertRule rule) {
        // Simple example: check if average latency > threshold in last duration
        LocalDateTime since = LocalDateTime.now().minusMinutes(rule.getDurationMinutes());
        List<HealthCheckLog> logs = healthCheckLogRepository.findByApiIdAndTimestampAfter(rule.getApi().getId(), since);

        double avgLatency = logs.stream()
                .filter(log -> log.getResponseTimeMs() != null)
                .mapToLong(HealthCheckLog::getResponseTimeMs)
                .average()
                .orElse(0);

        if (avgLatency > rule.getThresholdValue()) {
            triggerAlert(rule, "Average latency " + avgLatency + "ms exceeds threshold");
        }
    }

    private void triggerAlert(AlertRule rule, String message) {
        AlertEvent event = new AlertEvent();
        event.setRule(rule);
        event.setMessage(message);
        event.setStatus("triggered");
        alertEventRepository.save(event);

        notificationService.sendNotification(event);
    }
}