package com.apimonitor.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "api_payload_templates")
public class ApiPayloadTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "api_id", nullable = false)
    private MonitoredApi api;

    private String name;
    private String contentType;
    private String payload;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public MonitoredApi getApi() { return api; }
    public void setApi(MonitoredApi api) { this.api = api; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContentType() { return contentType; }
    public void setContentType(String contentType) { this.contentType = contentType; }

    public String getPayload() { return payload; }
    public void setPayload(String payload) { this.payload = payload; }
}