package com.example.empikzadanierekrutacyjne.model;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String login){
        super("Could not find user " + login);
    }
}
