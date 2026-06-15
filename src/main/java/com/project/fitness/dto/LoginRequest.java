package com.project.fitness.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "object for log in the user")
public class LoginRequest {
    @NotBlank(message = "Email Id is required")
    @Schema(
            description = "User's email address",
            example = "john.doe@example.com"
    )
    @Size(min = 5,max = 30,message = "username must be between 5 to 30 characters")
    private String username;
    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 20,
            message = "Password must be between 8 and 20 characters")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).*$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character"
    )
    @Schema(
            description = "Password between 8 and 20 characters containing at least one uppercase letter, one lowercase letter, one digit, and one special character",
            example = "Password@123"
    )
    private String password;
}
