package com.techeer.inforplanbackend.domain.project.domain.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name="project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long project_id;
}
