package com.apimonitor.repository;

import com.apimonitor.entity.MonitoredApi;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MonitoredApiRepository extends JpaRepository<MonitoredApi, Long> {
    List<MonitoredApi> findByCreatedById(Long userId);
}