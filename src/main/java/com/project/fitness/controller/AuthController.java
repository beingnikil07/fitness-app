package com.project.fitness.controller;

import com.project.fitness.dto.LoginRequest;
import com.project.fitness.dto.UserRequest;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.service.AuthService;
import com.project.fitness.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(
        name = "Authentication APIs",
        description = "APIs for user registration and authentication"
)
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    private static final Logger logger= LoggerFactory.getLogger(AuthController.class);

    @Operation(
            summary = "Register a new user",
            description = "Creates a new user account using email, password, first name, and last name."
    )
    @PostMapping("/register")
    public UserResponse registerUser( @Valid @RequestBody UserRequest userRequest) {
        logger.info("Register request received for username:{}",userRequest.getUsername());
        return  userService.registerUser(userRequest);

    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequest loginRequest) {

        logger.info("Login request received for the username:{}",loginRequest.getUsername());
        try {
            return authService.login(loginRequest);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
