package com.project.fitness.service;

import com.project.fitness.dto.UserRequest;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.model.User;
import com.project.fitness.repository.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Builder
public class UserService {

    private final UserRepository userRepository;

    public UserResponse registerUser(UserRequest userRequest)
    {

        User user = User.builder()
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .build();

//        User user=new User(
//                null,
//                userRequest.getEmail(),
//                userRequest.getPassword(),
//                userRequest.getFirstName(),
//                userRequest.getLastName(),
//                Instant.parse("2025-12-08T14:49:41.208Z")
//                        .atZone(ZoneOffset.UTC)
//                        .toLocalDateTime(),
//                Instant.parse("2025-12-08T14:49:45.208Z")
//                        .atZone(ZoneOffset.UTC).toLocalDateTime(),
//                List.of(),    //for activities ==empty list
//                List.of()    //for recommendations ==empty list
//        );

        User savedUser=userRepository.save(user);
        return  mapToResponse(savedUser);
    }

    //convert saved user to ResponseUser DTO
    private UserResponse mapToResponse(User savedUser)
    {
        UserResponse userResponse=new UserResponse();
        userResponse.setUserId(savedUser.getUserId());
        userResponse.setEmail(savedUser.getEmail());
        userResponse.setPassword(savedUser.getPassword());
        userResponse.setFirstName(savedUser.getFirstName());
        userResponse.setLastName(savedUser.getLastName());
        userResponse.setCreatedAt(savedUser.getCreatedAt());
        userResponse.setUpdatedAt(savedUser.getUpdatedAt());
        return userResponse;
    }



}
