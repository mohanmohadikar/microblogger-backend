package com.mohanmmohadikar.microbloggerbackend.controller;


import com.mohanmmohadikar.microbloggerbackend.config.JwtProvider;
import com.mohanmmohadikar.microbloggerbackend.exception.UserException;
import com.mohanmmohadikar.microbloggerbackend.model.User;
import com.mohanmmohadikar.microbloggerbackend.repository.UserRepository;
import com.mohanmmohadikar.microbloggerbackend.response.AuthResponse;
import com.mohanmmohadikar.microbloggerbackend.service.CustomUserDetailsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private CustomUserDetailsServiceImplementation customUserDetails;

    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws UserException {
        return null;
    }
}
