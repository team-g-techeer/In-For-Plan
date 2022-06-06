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
@Table(name = "social_users")
@RequiredArgsConstructor
public class SocialUsers extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "profile", nullable = true)
    private String url;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    private Role user_role;

    @Builder
    public SocialUsers(String email, String name, String url, Role user_role) {
        this.email = email;
        this.name = name;
        this.url = url;
        this.user_role = user_role;
    }

    public SocialUsers update(String name, String url) {
        this.name = name;
        this.url = url;

        return this;
    }

    public String getRoleKey() {
        return this.user_role.getValue();
    }
}