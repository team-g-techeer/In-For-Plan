package com.techeer.inforplanbackend.domain.project.domain.entity;

import lombok.Builder;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long task_id;

    @Column(name="list_id", nullable=false)
    private Long list_id;
    @Column(name="project_id", nullable=false)
    private Long project_id;

    @Column(name="description", nullable=false, length=500)
    private String description;
    @Column(name="start_date", nullable=false)
    private java.sql.Date start_date;
    @Column(name="created_at", nullable=false)
    private LocalDate created_at = LocalDate.now();
    @Column(name="end_date", nullable=false)
    private java.sql.Date end_date;
    @Column(name="updated_at", nullable=false)
    private LocalDate updated_at = LocalDate.now();

    @Column(name="file", nullable=true)
    private String file_url;

    @Column(name="task_title", nullable=false)
    private String task_title;

    @Builder
    public Task(Long list_id, Long project_id, String description, java.sql.Date start_date, LocalDate created_at, java.sql.Date end_date, LocalDate updated_at, String file_url, String task_title) {
        this.list_id = list_id;
        this.project_id = project_id;
        this.description = description;
        this.start_date = start_date;
        this.created_at = created_at;
        this.end_date = end_date;
        this.updated_at = updated_at;
        this.file_url = file_url;
        this.task_title = task_title;
    }

    public String getTask_title() {
        return this.task_title;
    }



    public Task() {

    }
}