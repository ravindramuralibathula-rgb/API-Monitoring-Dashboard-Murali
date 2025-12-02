package com.apimonitor.controller;

import com.apimonitor.entity.HealthCheckLog;
import com.apimonitor.repository.HealthCheckLogRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Logs", description = "Health check logs APIs")
@RestController
@RequestMapping("/api/logs")
public class LogsController {

    private final HealthCheckLogRepository healthCheckLogRepository;

    public LogsController(HealthCheckLogRepository healthCheckLogRepository) {
        this.healthCheckLogRepository = healthCheckLogRepository;
    }

    @GetMapping("/{apiId}")
    public List<HealthCheckLog> getLogs(@PathVariable Long apiId) {
        return healthCheckLogRepository.findByApiIdOrderByTimestampDesc(apiId);
    }
}