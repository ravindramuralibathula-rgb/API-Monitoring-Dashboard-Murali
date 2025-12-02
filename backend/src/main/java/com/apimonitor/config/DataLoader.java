package com.apimonitor.config;

import com.apimonitor.entity.MonitoredApi;
import com.apimonitor.entity.User;
import com.apimonitor.repository.MonitoredApiRepository;
import com.apimonitor.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, MonitoredApiRepository monitoredApiRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.count() == 0) {
                User admin = new User();
                admin.setEmail("admin@example.com");
                admin.setPasswordHash(passwordEncoder.encode("Password123!"));
                admin.setRole(User.Role.ADMIN);
                admin.setCreatedAt(LocalDateTime.now());
                userRepository.save(admin);

                MonitoredApi endpoint1 = new MonitoredApi();
                endpoint1.setName("Healthy Endpoint");
                endpoint1.setUrl("https://httpstat.us/200?sleep=100");
                endpoint1.setMethod("GET");
                endpoint1.setExpectedStatusCodesJson("[200]");
                endpoint1.setFrequencySeconds(60);
                endpoint1.setTimeoutMs(5000);
                endpoint1.setEnabled(true);
                endpoint1.setCreatedBy(admin);
                endpoint1.setCreatedAt(LocalDateTime.now());
                monitoredApiRepository.save(endpoint1);

                MonitoredApi endpoint2 = new MonitoredApi();
                endpoint2.setName("Failing Endpoint");
                endpoint2.setUrl("https://httpstat.us/503");
                endpoint2.setMethod("GET");
                endpoint2.setExpectedStatusCodesJson("[200]");
                endpoint2.setFrequencySeconds(60);
                endpoint2.setTimeoutMs(5000);
                endpoint2.setEnabled(true);
                endpoint2.setCreatedBy(admin);
                endpoint2.setCreatedAt(LocalDateTime.now());
                monitoredApiRepository.save(endpoint2);
            }
        };
    }
}