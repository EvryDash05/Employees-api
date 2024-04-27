package com.example.employeeapi.config;

import org.springframework.data.domain.AuditorAware;
import java.util.Optional;

public class Auditor implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("System");
    }
}
