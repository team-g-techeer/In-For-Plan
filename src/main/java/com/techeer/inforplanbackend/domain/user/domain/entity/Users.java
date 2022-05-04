package com.techeer.inforplanbackend.domain.user.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


import javax.persistence.*;

@Getter
@Entity
@RequiredArgsConstructor
public class Users {

    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone_number", nullable = true)
    private String phoneNumber;

    @Column(name = "profile", nullable = true)
    private String url;

    @Column(name = "birth_date", nullable = true)
    private java.sql.Date birthDate;

    @Column(name = "create_at", nullable = false)
    private java.sql.Date created_at;

    @Column(name = "update_at")
    private java.sql.Date update_at;

    @Builder
    public Users(String email, String password, String name, String phoneNumber, String url, java.sql.Date birthDate, java.sql.Date created_at, java.sql.Date updated_at) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.url = url;
        this.birthDate = birthDate;
        this.created_at = created_at;
        this.update_at = updated_at;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
