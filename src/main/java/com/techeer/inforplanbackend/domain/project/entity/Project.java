package com.techeer.inforplanbackend.domain.project.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
@RequiredArgsConstructor

public class Project {

    @Id @GeneratedValue
    @Column(name= "id")
    private Long id;

    @Column(name = "project_title", nullable = false)
    private String project_title;

    @Column(name = "created_at", nullable = false)
    private java.sql.Date created_at;

    @Column(name = "updated_at", nullable = false)
    private java.sql.Date updated_at;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "meet_date")
    private  java.sql.Date meet_date;

    @Builder
    public Project(String project_title, java.sql.Date created_at,java.sql.Date updated_at,String url,java.sql.Date meet_date)
    {
        this.project_title = project_title;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.url = url;
        this.meet_date = meet_date;
    }

}
