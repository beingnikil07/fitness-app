package com.project.fitness.Exceptions;

public class UserNameAlreadyExist extends RuntimeException {
    public UserNameAlreadyExist(String message){
        super(message);
    }
}
