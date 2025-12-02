package com.apimonitor.service;

import com.apimonitor.entity.HealthCheckLog;
import com.apimonitor.repository.HealthCheckLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SlaEngine {

    private final HealthCheckLogRepository healthCheckLogRepository;

    public SlaEngine(HealthCheckLogRepository healthCheckLogRepository) {
        this.healthCheckLogRepository = healthCheckLogRepository;
    }

    public double calculateUptime(Long apiId, LocalDateTime since) {
        List<HealthCheckLog> logs = healthCheckLogRepository.findByApiIdAndTimestampAfter(apiId, since);
        long total = logs.size();
        long successful = logs.stream().filter(log -> Boolean.TRUE.equals(log.getSuccess())).count();
        return total > 0 ? (double) successful / total * 100 : 0;
    }
}