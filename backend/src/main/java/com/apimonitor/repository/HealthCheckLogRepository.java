package com.apimonitor.repository;

import com.apimonitor.entity.HealthCheckLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface HealthCheckLogRepository extends JpaRepository<HealthCheckLog, Long> {
    List<HealthCheckLog> findByApiIdOrderByTimestampDesc(Long apiId);
    List<HealthCheckLog> findByApiIdAndTimestampAfter(Long apiId, LocalDateTime timestamp);
}