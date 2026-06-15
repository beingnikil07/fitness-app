package com.project.fitness.repository;

import com.project.fitness.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(@NotBlank(message = "username is required") @Size(min = 5, max = 30,
            message = "username must be between 5 and 30 characters") String username);
}
