package com.techeer.inforplanbackend.domain.user.domain.entity;

import lombok.Builder;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @Id @GeneratedValue
    private Long id;
    private String email;
    private String password;
    private String name;
    private String number;
    private String url;
    private java.sql.Date birth;
    private java.sql.Date created_at;
    private java.sql.Date update_at;

    protected User() {}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
