package com.project.fitness.controller;

import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.model.Recommendation;
import com.project.fitness.service.RecommendationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendation")
@RequiredArgsConstructor
@Validated
@Tag(
        name = "Recommendation APIs",
        description = "APIs for generating and retrieving fitness recommendations"
)
public class RecommendationController {

    private final RecommendationService recommendationService;
    private static final Logger logger= LoggerFactory.getLogger(RecommendationController.class);

    @Operation(
            summary = "Generate recommendation",
            description = "Generates a personalized recommendation for a user based on activity data."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Recommendation generated successfully",
                    content = @Content(schema = @Schema(implementation = Recommendation.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request",
                    content = @Content
            )
    })

    @PostMapping("/generate")
    public ResponseEntity<Recommendation> generateRecommendation(@Valid @RequestBody RecommendationRequest request){
        logger.info("Recommendation generation request is received");
        Recommendation recommendation=recommendationService.generateRecommendation(request);
        return ResponseEntity.ok(recommendation);
    }

    @Operation(
            summary = "Get recommendations by user ID",
            description = "Returns all recommendations associated with a specific user."
    )
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Recommendation>> getUserRecommendation(@PathVariable  @NotBlank(message = "User Id cannot be blank")
                                                                          @Parameter(
                                                                                  description = "Unique identifier of the user",
                                                                                  example = "USR001"
                                                                          )
                                                                          String userId){

        List<Recommendation> recommendationList=recommendationService.getUserRecommendation(userId);
        return ResponseEntity.ok(recommendationList);
    }

    @Operation(
            summary = "Get recommendations by activity ID",
            description = "Returns all recommendations associated with a specific activity."
    )
    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<Recommendation>> getActivityRecommendation(@PathVariable @NotBlank(message = "Activity Id cannot be blank")
                                                                              @Parameter(
                                                                                      description = "Unique identifier of the activity",
                                                                                      example = "ACT101"
                                                                              )
                                                                              String activityId){
        List<Recommendation> recommendationList=recommendationService.getActivityRecommendation(activityId);
        return ResponseEntity.ok(recommendationList);
    }

}
