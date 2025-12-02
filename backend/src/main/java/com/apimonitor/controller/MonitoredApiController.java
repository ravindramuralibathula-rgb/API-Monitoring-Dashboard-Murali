package com.apimonitor.controller;

import com.apimonitor.entity.MonitoredApi;
import com.apimonitor.entity.User;
import com.apimonitor.repository.MonitoredApiRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Tag(name = "Monitored APIs", description = "Monitored API management APIs")
@RestController
@RequestMapping("/api/apis")
public class MonitoredApiController {

    private final MonitoredApiRepository monitoredApiRepository;

    public MonitoredApiController(MonitoredApiRepository monitoredApiRepository) {
        this.monitoredApiRepository = monitoredApiRepository;
    }

    @GetMapping
    public List<MonitoredApi> getApis(@AuthenticationPrincipal UserDetails userDetails) {
        // For simplicity, return all; in multi-user, filter by user
        return monitoredApiRepository.findAll();
    }

    @PostMapping
    public MonitoredApi createApi(@RequestBody MonitoredApi api, @AuthenticationPrincipal UserDetails userDetails) {
        // Mock user for now
        User user = new User();
        user.setId(1L);
        api.setCreatedBy(user);
        api.setCreatedAt(LocalDateTime.now());
        return monitoredApiRepository.save(api);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonitoredApi> getApi(@PathVariable Long id) {
        return monitoredApiRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonitoredApi> updateApi(@PathVariable Long id, @RequestBody MonitoredApi api) {
        if (!monitoredApiRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        api.setId(id);
        return ResponseEntity.ok(monitoredApiRepository.save(api));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApi(@PathVariable Long id) {
        if (!monitoredApiRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        monitoredApiRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}