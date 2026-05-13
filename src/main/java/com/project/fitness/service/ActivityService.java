package com.project.fitness.service;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.model.Activity;
import com.project.fitness.model.User;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;

    public ActivityResponse trackActivity(ActivityRequest activityRequest) {

        User user=userRepository.findById(activityRequest.getUserId()).orElseThrow(()->new RuntimeException("user not found"));

        Activity activity=Activity.builder()
                .caloriesBurned(activityRequest.getCaloriesBurned())
                .type(activityRequest.getType())
                .duration(activityRequest.getDuration())
                .additionalMetrices(activityRequest.getAdditionalMetrices())
                .startTime(activityRequest.getStartTime())
                .user(user)
                .build();

           Activity savedActivity= activityRepository.save(activity);
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
        List<Activity> activitityList=activityRepository.findByUserUserId(userId);
        return activitityList.stream().map(this::mapToResponse)
                .collect(Collectors.toList());
    }

}
