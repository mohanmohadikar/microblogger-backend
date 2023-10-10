package com.mohanmmohadikar.microbloggerbackend.model;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Verification {
    private boolean status;
    private LocalDateTime startedAt;
    private LocalDateTime endAt;
    private String planType;
}
