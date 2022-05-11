package com.techeer.inforplanbackend.domain.user.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techeer.inforplanbackend.global.common.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


import javax.persistence.*;
import java.sql.Date;

@Getter
@Entity
@RequiredArgsConstructor
public class Users extends BaseTimeEntity {

    @Id
    @GeneratedValue
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
    private Date birthDate;

    @Builder
    public Users(String email, String password, String name, String phoneNumber, String url, Date birthDate) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.url = url;
        this.birthDate = birthDate;
    }
}
