package com.apimonitor.controller;

import com.apimonitor.entity.SlaProfile;
import com.apimonitor.repository.SlaProfileRepository;
import com.apimonitor.service.SlaEngine;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Tag(name = "SLA", description = "SLA management APIs")
@RestController
@RequestMapping("/api/sla")
public class SlaController {

    private final SlaProfileRepository slaProfileRepository;
    private final SlaEngine slaEngine;

    public SlaController(SlaProfileRepository slaProfileRepository, SlaEngine slaEngine) {
        this.slaProfileRepository = slaProfileRepository;
        this.slaEngine = slaEngine;
    }

    @GetMapping("/profiles")
    public List<SlaProfile> getSlaProfiles() {
        return slaProfileRepository.findAll();
    }

    @PostMapping("/profiles")
    public SlaProfile createSlaProfile(@RequestBody SlaProfile profile) {
        return slaProfileRepository.save(profile);
    }

    @GetMapping("/uptime/{apiId}")
    public double getUptime(@PathVariable Long apiId, @RequestParam(defaultValue = "24") int hours) {
        LocalDateTime since = LocalDateTime.now().minusHours(hours);
        return slaEngine.calculateUptime(apiId, since);
    }
}