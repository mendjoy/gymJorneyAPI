package io.github.mendjoy.gymJourneyAPI.dto.user;

public class UserRegisterDTO {

    private Integer id;
    private String email;
    private String name;
    private String password;

    public UserRegisterDTO(String email, Integer id, String name, String password) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
