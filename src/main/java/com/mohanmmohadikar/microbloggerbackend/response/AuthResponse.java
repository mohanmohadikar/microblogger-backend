package com.mohanmmohadikar.microbloggerbackend.response;


import lombok.Data;

@Data
public class AuthResponse {
    private String jwt;
    private boolean status;
}
