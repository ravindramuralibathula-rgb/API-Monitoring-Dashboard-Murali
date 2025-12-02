package com.apimonitor.service;

import com.apimonitor.entity.HealthCheckLog;
import com.apimonitor.entity.MonitoredApi;
import com.apimonitor.repository.HealthCheckLogRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class HealthCheckServiceTest {

    @Mock
    private HealthCheckLogRepository healthCheckLogRepository;

    @InjectMocks
    private HealthCheckService healthCheckService;

    @Test
    void testPerformCheck() {
        MockitoAnnotations.openMocks(this);
        MonitoredApi api = new MonitoredApi();
        api.setId(1L);
        api.setUrl("http://example.com");

        HealthCheckLog log = new HealthCheckLog();
        when(healthCheckLogRepository.save(any())).thenReturn(log);

        healthCheckService.performCheck(api);

        verify(healthCheckLogRepository, times(1)).save(any(HealthCheckLog.class));
    }
}