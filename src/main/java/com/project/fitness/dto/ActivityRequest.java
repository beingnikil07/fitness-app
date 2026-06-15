package com.project.fitness.dto;


import com.project.fitness.model.ActivityType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Request object for creating a fitness activity")
public class ActivityRequest {
    @Schema(
            description = "Unique identifier of the user",
            example = "USR001"
    )
    @NotBlank(message = "User Id cannot be blank")
    private String userId;
    @Schema(
            description = "Type of activity performed",
            example = "RUNNING"
    )
    @NotNull(message = "Activity type is required")
    private ActivityType type;

    @Schema(
            description = "Additional metrics related to the activity such as distance, steps, average heart rate, etc.",
            example = "{\"distance\":5.2,\"steps\":6500}"
    )
    private Map<String, Object> additionalMetrices;
    @NotNull(message = "Duration is required")
    @Positive(message = "Duration must be greater than 0")
    @Schema(
            description = "Duration of the activity in minutes",
            example = "45"
    )
    private String duration;
    @NotNull(message = "Calories burned is required")
    @Positive(message = "Calories burned must be greater than 0")
    @Schema(
            description = "Total calories burned during the activity",
            example = "350"
    )
    private String caloriesBurned;
    @Schema(
            description = "Start time of the activity",
            example = "2026-06-11T06:30:00"
    )
    @NotNull(message = "Start time is required")
    private LocalDateTime startTime;
}
