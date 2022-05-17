package com.techeer.inforplanbackend.domain.list.entity;

import com.techeer.inforplanbackend.domain.project.entity.Project;
import com.techeer.inforplanbackend.domain.project.domain.entity.Task;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class List {

    @Id @GeneratedValue
    @Column(name = "list_id")
    private Long list_id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    private String list_title;

    private java.sql.Date create_at;

//    private java.sql.Date updated_at;

    @OneToMany(mappedBy = "list")
    private List<Task> tasks = new ArrayList<>();
}
