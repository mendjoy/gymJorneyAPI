package io.github.mendjoy.gymJourneyAPI.dto.user;

import java.util.Date;

public class UserRegisterDTO {

    private Integer id;
    private String email;
    private String name;
    private String phone;
    private Date birth_date;
    private String password;

    public UserRegisterDTO(String email, Integer id, String name, String phone, Date birth_date, String password) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.birth_date = birth_date;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
