package com.example.empikzadanierekrutacyjne.service;

import com.example.empikzadanierekrutacyjne.dao.UserStoredRepository;
import com.example.empikzadanierekrutacyjne.model.User;
import com.example.empikzadanierekrutacyjne.model.UserStored;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRepositoryService {
    private final UserStoredRepository repository;

    @Autowired
    public UserRepositoryService(UserStoredRepository repository) {
        this.repository = repository;
    }
    public boolean processUser(User user){
        Long githubId = user.getId();
        Optional<UserStored> storedUser = repository.findById(githubId);
        UserStored tmpUser = new UserStored();
        tmpUser.setId(githubId);

        storedUser.ifPresentOrElse(
                val -> {
                    tmpUser.setLogin(val.getLogin());
                    tmpUser.setRequestCount(val.getRequestCount() + 1);

                },
                () -> {
                    tmpUser.setLogin(user.getLogin());
                    tmpUser.setRequestCount(1L);
                }
        );

        repository.save(tmpUser);
        return true;
    }

    public Optional<UserStored> checkUserStats(Long githubId){
        return repository.findById(githubId);
    }
}
