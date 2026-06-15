package com.project.fitness.service;

import com.project.fitness.model.User;
import com.project.fitness.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final static Logger logger= LoggerFactory.getLogger(CustomUserDetailsService.class);

    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository=userRepository;
        System.out.println("CustomUserDetailsService CREATED");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //got the username from DB
        User user=userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User not found"));
        logger.info("CustomUserDetailsService CREATED");
       return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(user.getPassword())
                .roles(user.getRoles())
                .build();
    }
}
