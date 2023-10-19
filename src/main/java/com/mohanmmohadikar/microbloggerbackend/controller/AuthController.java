package com.mohanmmohadikar.microbloggerbackend.controller;


import com.mohanmmohadikar.microbloggerbackend.config.JwtProvider;
import com.mohanmmohadikar.microbloggerbackend.exception.UserException;
import com.mohanmmohadikar.microbloggerbackend.model.User;
import com.mohanmmohadikar.microbloggerbackend.model.Verification;
import com.mohanmmohadikar.microbloggerbackend.repository.UserRepository;
import com.mohanmmohadikar.microbloggerbackend.response.AuthResponse;
import com.mohanmmohadikar.microbloggerbackend.service.CustomUserDetailsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
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


    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws UserException {

        String email = user.getEmail();
        String password = user.getPassword();
        String fullName = user.getFullName();
        String dob = user.getDob();

        User isEmailExists = userRepository.findByEmail(email);

        if (isEmailExists != null) {
            throw new UserException("Email is already user with another account");
        }

        User createdUser = User.builder()
                .email(email)
                .password(password)
                .fullName(fullName)
                .dob(dob)
                .verification(new Verification())
                .build();

        User savedUser = userRepository.save(createdUser);

        Authentication authentication = new UsernamePasswordAuthenticationToken(email, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.generateToken(authentication);

        AuthResponse res = new AuthResponse(token, true);

        return new ResponseEntity<AuthResponse>(res, HttpStatus.CREATED);
    }
}
