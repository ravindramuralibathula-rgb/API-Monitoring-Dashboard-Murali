package com.apimonitor.controller;

import com.apimonitor.entity.AlertEvent;
import com.apimonitor.entity.AlertRule;
import com.apimonitor.repository.AlertEventRepository;
import com.apimonitor.repository.AlertRuleRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Alerts", description = "Alert management APIs")
@RestController
@RequestMapping("/api/alerts")
public class AlertsController {

    private final AlertRuleRepository alertRuleRepository;
    private final AlertEventRepository alertEventRepository;

    public AlertsController(AlertRuleRepository alertRuleRepository, AlertEventRepository alertEventRepository) {
        this.alertRuleRepository = alertRuleRepository;
        this.alertEventRepository = alertEventRepository;
    }

    @GetMapping("/rules")
    public List<AlertRule> getAlertRules() {
        return alertRuleRepository.findAll();
    }

    @PostMapping("/rules")
    public AlertRule createAlertRule(@RequestBody AlertRule rule) {
        return alertRuleRepository.save(rule);
    }

    @GetMapping("/events")
    public List<AlertEvent> getAlertEvents() {
        return alertEventRepository.findAll();
    }

    @PutMapping("/events/{id}/ack")
    public AlertEvent acknowledgeAlert(@PathVariable Long id) {
        AlertEvent event = alertEventRepository.findById(id).orElseThrow();
        event.setStatus("acknowledged");
        return alertEventRepository.save(event);
    }
}