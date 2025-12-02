package com.apimonitor.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "aggregates")
public class Aggregate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "api_id", nullable = false)
    private MonitoredApi api;

    private LocalDateTime windowStart;
    private Integer windowMinutes;
    private Long p50Ms;
    private Long p90Ms;
    private Long p99Ms;
    private Double avgMs;
    private Double errorRate;
    private Long count;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public MonitoredApi getApi() { return api; }
    public void setApi(MonitoredApi api) { this.api = api; }

    public LocalDateTime getWindowStart() { return windowStart; }
    public void setWindowStart(LocalDateTime windowStart) { this.windowStart = windowStart; }

    public Integer getWindowMinutes() { return windowMinutes; }
    public void setWindowMinutes(Integer windowMinutes) { this.windowMinutes = windowMinutes; }

    public Long getP50Ms() { return p50Ms; }
    public void setP50Ms(Long p50Ms) { this.p50Ms = p50Ms; }

    public Long getP90Ms() { return p90Ms; }
    public void setP90Ms(Long p90Ms) { this.p90Ms = p90Ms; }

    public Long getP99Ms() { return p99Ms; }
    public void setP99Ms(Long p99Ms) { this.p99Ms = p99Ms; }

    public Double getAvgMs() { return avgMs; }
    public void setAvgMs(Double avgMs) { this.avgMs = avgMs; }

    public Double getErrorRate() { return errorRate; }
    public void setErrorRate(Double errorRate) { this.errorRate = errorRate; }

    public Long getCount() { return count; }
    public void setCount(Long count) { this.count = count; }
}