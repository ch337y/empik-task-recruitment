package com.example.empikzadanierekrutacyjne.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserStored {
    private @Id Long id;
    private String login;
    private Long requestCount;

    public String getLogin() {
        return login;
    }

    public Long getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(Long requestCount) {
        this.requestCount = requestCount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
