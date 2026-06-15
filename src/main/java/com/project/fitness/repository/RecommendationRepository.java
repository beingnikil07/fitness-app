package com.project.fitness.repository;

import com.project.fitness.model.Recommendation;
import com.project.fitness.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation,String> {

    List<Recommendation> findByUser_UserId(String userId);

    String user(User user);

    List<Recommendation> findByActivityId(String activityId);
}
