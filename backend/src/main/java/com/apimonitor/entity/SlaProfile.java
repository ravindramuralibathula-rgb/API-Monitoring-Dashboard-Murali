package com.apimonitor.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sla_profiles")
public class SlaProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double uptimePercentage; // e.g., 99.9
    private Integer maxResponseTimeMs;
    private String description;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getUptimePercentage() { return uptimePercentage; }
    public void setUptimePercentage(Double uptimePercentage) { this.uptimePercentage = uptimePercentage; }

    public Integer getMaxResponseTimeMs() { return maxResponseTimeMs; }
    public void setMaxResponseTimeMs(Integer maxResponseTimeMs) { this.maxResponseTimeMs = maxResponseTimeMs; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}