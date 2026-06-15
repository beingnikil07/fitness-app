package com.project.fitness.service;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.model.Activity;
import com.project.fitness.model.User;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;

    public ActivityResponse trackActivity(ActivityRequest activityRequest) {
        log.info("Tracking activity for user {}", activityRequest.getUserId());
        User user=userRepository.findById(activityRequest.getUserId()).orElseThrow(()->{
                log.error("User with id {} not found", activityRequest.getUserId());
                return new RuntimeException("user not found");
        });

        Activity activity=Activity.builder()
                .caloriesBurned(activityRequest.getCaloriesBurned())
                .type(activityRequest.getType())
                .duration(activityRequest.getDuration())
                .additionalMetrices(activityRequest.getAdditionalMetrices())
                .startTime(activityRequest.getStartTime())
                .user(user)
                .build();
        log.debug("Saving {} activity for user {}",
                activityRequest.getType(),
                activityRequest.getUserId());

           Activity savedActivity= activityRepository.save(activity);
           log.info("Activity {} saved successfully for user {}",
                savedActivity.getId(),
                activityRequest.getUserId());

        return  mapToResponse(savedActivity);
    }

    //Converting savedActivity to ResponseActivity DTOs
    private ActivityResponse mapToResponse(Activity activity) {
        ActivityResponse response=new ActivityResponse();
        response.setId(activity.getId());
        response.setUserId(activity.getUser().getUserId());
        response.setType(activity.getType());
        response.setAdditionalMetrices(activity.getAdditionalMetrices());
        response.setDuration(activity.getDuration());
        response.setCaloriesBurned(activity.getCaloriesBurned());
        response.setStartTime(activity.getStartTime());
        response.setCreatedAt(activity.getCreatedAt());
        response.setUpdatedAt(activity.getUpdatedAt());

        return  response;
    }

    public List<ActivityResponse> getActivities(String userId){
        log.info("Fetching activities for user {}", userId);
        List<Activity> activityList=activityRepository.findByUserUserId(userId);
        log.info("Found {} activities for user {}",
                activityList.size(),
                userId);
        return activityList.stream().map(this::mapToResponse)
                .collect(Collectors.toList());
    }

}
