package com.project.fitness.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request object for providing activity recommendations to a user")
public class RecommendationRequest
{
    @Schema(
            description = "Unique identifier of the user",
            example = "USR001"
    )
    @NotBlank(message = "User ID is required")
    private String userId;
    @Schema(
            description = "Unique identifier of the activity",
            example = "ACT101"
    )
    @NotBlank(message = "Activity ID is required")
    private String activityId;
    @Schema(
            description = "List of areas where the user can improve",
            example = "[\"Increase running duration\", \"Maintain proper posture\"]"
    )
    @NotEmpty(message = "Improvements list cannot be empty")
    private List<@NotBlank(message = "Improvement cannot be blank") String> improvements;

    @NotEmpty(message = "Suggestions list cannot be empty")
    @Schema(
            description = "List of suggestions to enhance performance",
            example = "[\"Stay hydrated\", \"Warm up before exercise\"]"
    )
    private List<@NotBlank(message = "Suggestions cannot be blank") String> suggestions;
    @NotEmpty(message = "Safety list cannot be empty")
    @Schema(
            description = "List of safety tips for the activity",
            example = "[\"Wear appropriate shoes\", \"Avoid overexertion\"]"
    )
    private List<@NotBlank(message = "Safety tips cannot be blank") String> safety;
}
