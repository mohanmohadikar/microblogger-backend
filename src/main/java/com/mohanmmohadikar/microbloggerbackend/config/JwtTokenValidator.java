package com.mohanmmohadikar.microbloggerbackend.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;

public class JwtTokenValidator extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Bearer jwt
        String jwt = request.getHeader(JwtConstant.JWT_HEADER);


        if (jwt != null) {
            jwt = jwt.substring(7);

            try {
                SecretKey key = "".getBytes();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}