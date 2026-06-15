package com.project.fitness.service;

import com.project.fitness.dto.LoginRequest;
import com.project.fitness.security.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
@Service
@Slf4j
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public AuthService(AuthenticationManager authenticationManager,JwtUtils jwtUtils){
        this.authenticationManager = authenticationManager;
        this.jwtUtils=jwtUtils;
    }

    public String login(LoginRequest loginRequest){

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequest.getUsername(),
                                loginRequest.getPassword()
                        )
                );
        log.info("User logged In successfully");
        return jwtUtils.generateToken(loginRequest.getUsername());
    }
}