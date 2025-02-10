package io.github.mendjoy.gymJourneyAPI.dto;

import io.github.mendjoy.gymJourneyAPI.entity.user.UserRole;

public class UserAuthDTO {

    private Integer id;
    private String name;
    private String email;
    private UserRole role;
    private String token;

    public UserAuthDTO() {
    }

    public UserAuthDTO(Integer id, String name, String email,UserRole role, String token) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
