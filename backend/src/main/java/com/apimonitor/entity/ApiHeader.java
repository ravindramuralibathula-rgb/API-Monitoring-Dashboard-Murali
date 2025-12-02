package com.apimonitor.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "api_headers")
public class ApiHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "api_id", nullable = false)
    private MonitoredApi api;

    private String headerName;
    private String headerValue;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public MonitoredApi getApi() { return api; }
    public void setApi(MonitoredApi api) { this.api = api; }

    public String getHeaderName() { return headerName; }
    public void setHeaderName(String headerName) { this.headerName = headerName; }

    public String getHeaderValue() { return headerValue; }
    public void setHeaderValue(String headerValue) { this.headerValue = headerValue; }
}