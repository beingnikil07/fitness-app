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
@Schema(description = "Request object for registering a new user")
public class UserRequest {
    @NotBlank(message = "Email Id is required")
    @Email(message = "Invalid Email format")
    @Schema(
            description = "User's email address",
            example = "john.doe@example.com"
    )
    private String email;

    @NotBlank(message = "username is required")
    @Size(min = 5, max = 30,
            message = "username must be between 5 and 30 characters")
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
    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50,
            message = "First name must be between 2 and 50 characters")
    @Schema(
            description = "User's first name",
            example = "John"
    )
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50,
            message = "Last name must be between 2 and 50 characters")
    @Schema(
            description = "User's last name",
            example = "Doe"
    )
    private String lastName;

}
