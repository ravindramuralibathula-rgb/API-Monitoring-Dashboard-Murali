package com.apimonitor.service;

import com.apimonitor.entity.MonitoredApi;
import com.apimonitor.repository.MonitoredApiRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CheckScheduler {

    private final MonitoredApiRepository monitoredApiRepository;
    private final HealthCheckService healthCheckService;

    public CheckScheduler(MonitoredApiRepository monitoredApiRepository, HealthCheckService healthCheckService) {
        this.monitoredApiRepository = monitoredApiRepository;
        this.healthCheckService = healthCheckService;
    }

    @Scheduled(fixedRate = 60000) // Every 60 seconds
    public void runChecks() {
        List<MonitoredApi> apis = monitoredApiRepository.findAll();
        for (MonitoredApi api : apis) {
            if (api.getEnabled() != null && api.getEnabled()) {
                healthCheckService.performCheck(api);
            }
        }
    }
}