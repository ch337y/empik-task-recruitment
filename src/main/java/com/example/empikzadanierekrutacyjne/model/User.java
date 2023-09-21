package com.example.empikzadanierekrutacyjne.model;

public class User {
    private Long id;
    private String login;
    private String name;
    private String type;
    private String avatarUrl;
    private String createdAt;
    private double calculations;

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public double getCalculations() {
        return calculations;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setCalculations(Long followers, Long publicRepos) {
        if(followers == 0 || publicRepos == 0){
            this.calculations = 0;
        }else{
            this.calculations = (double) 6 / followers * (2 + publicRepos);
        }

    }
}
