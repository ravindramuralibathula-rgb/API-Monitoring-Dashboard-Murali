package com.apimonitor.repository;

import com.apimonitor.entity.SlaProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlaProfileRepository extends JpaRepository<SlaProfile, Long> {
}