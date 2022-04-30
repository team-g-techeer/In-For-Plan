package com.techeer.inforplanbackend.domain.user.domain.entity;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private String email;
    private String name;
    private String number;
    private String url;
    private java.sql.Date birth;
    private java.sql.Date created_at;
    private java.sql.Date update_at;
}
