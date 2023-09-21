package com.example.empikzadanierekrutacyjne.dao;

import com.example.empikzadanierekrutacyjne.model.UserStored;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserStoredRepository extends JpaRepository<UserStored, Long> {

    UserStored save(UserStored storedUser);
}
