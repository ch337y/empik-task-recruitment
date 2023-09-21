package com.example.empikzadanierekrutacyjne.controller;

import com.example.empikzadanierekrutacyjne.model.User;
import com.example.empikzadanierekrutacyjne.model.UserStored;
import com.example.empikzadanierekrutacyjne.service.UserRepositoryService;
import com.example.empikzadanierekrutacyjne.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;
    private final UserRepositoryService userRepositoryService;

    @Autowired
    public UserController(UserService userService, UserRepositoryService userRepositoryService) {
        this.userService = userService;
        this.userRepositoryService = userRepositoryService;
    }

    @GetMapping("/users/{login}")
    User singleUser(@PathVariable String login){
        try {
            User user = userService.getUserViaLogin(login);
            userRepositoryService.processUser(user);
            return user;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/users/statistics/{id}")
    Optional<UserStored> singleUser(@PathVariable Long id){
        Optional<UserStored> optionalUser = userRepositoryService.checkUserStats(id);
        return optionalUser;
    }
}
