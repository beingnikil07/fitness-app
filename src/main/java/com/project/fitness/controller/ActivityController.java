package com.project.fitness.controller;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.service.ActivityService;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("/api/activities")
@RequiredArgsConstructor
@Validated
@Tag(
        name = "Activity APIs",
        description = "APIs for tracking and retrieving user activities"
)
public class ActivityController {

        private final ActivityService  activityService;

        private static final Logger logger= LoggerFactory.getLogger(ActivityController.class);



    @Operation(
            summary = "Track a new activity",
            description = "Creates and stores a new activity for a user."
    )
        @PostMapping
        public ResponseEntity<ActivityResponse> trackActivity(@Valid @RequestBody ActivityRequest request){
            logger.info("Request received for creating an activity");
            return  ResponseEntity.ok(activityService.trackActivity(request));
        }

    @Operation(
            summary = "Get all activities of a user",
            description = "Returns the list of activities associated with the specified user."
    )
        @GetMapping
        public ResponseEntity<List<ActivityResponse>> getActivities( @RequestHeader(value ="X-User-ID")  @NotBlank(message = "User Id cannot be blank") String userId){
        logger.info("getting all the activities ");
        return ResponseEntity.ok(activityService.getActivities(userId));
        }



}
