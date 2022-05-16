package com.techeer.inforplanbackend.domain.project.domain.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name="list")
public class List {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long list_id;
}
