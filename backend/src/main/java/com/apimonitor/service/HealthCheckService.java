package com.apimonitor.service;

import com.apimonitor.entity.HealthCheckLog;
import com.apimonitor.entity.MonitoredApi;
import com.apimonitor.repository.HealthCheckLogRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class HealthCheckService {

    private final HealthCheckLogRepository healthCheckLogRepository;
    private final RestTemplate restTemplate = new RestTemplate();

    public HealthCheckService(HealthCheckLogRepository healthCheckLogRepository) {
        this.healthCheckLogRepository = healthCheckLogRepository;
    }

    public HealthCheckLog performCheck(MonitoredApi api) {
        HealthCheckLog log = new HealthCheckLog();
        log.setApi(api);
        log.setTimestamp(LocalDateTime.now());
        log.setTraceId(UUID.randomUUID().toString());

        long start = System.currentTimeMillis();
        try {
            // Simple GET for now
            ResponseEntity<String> response = restTemplate.getForEntity(api.getUrl(), String.class);
            long end = System.currentTimeMillis();

            log.setResponseTimeMs(end - start);
            log.setStatusCode(response.getStatusCodeValue());
            log.setSuccess(true);
            log.setResponseSize((long) response.getBody().length());
        } catch (Exception e) {
            long end = System.currentTimeMillis();
            log.setResponseTimeMs(end - start);
            log.setSuccess(false);
            log.setErrorMessage(e.getMessage());
        }

        return healthCheckLogRepository.save(log);
    }
}