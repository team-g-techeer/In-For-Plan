package com.techeer.inforplanbackend.domain.project.domain.entity;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Getter
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long task_id;
    @Column(name="list_date", nullable=false)
    private Long list_id;
    @Column(name="project_id", nullable=false)
    private Long project_id;
//    @ManyToOne
//    @JoinColumn(name = "list_id")
//    private List list_id;
//
//    @ManyToOne
//    @JoinColumn(name = "project_id")
//    private Project project_id;

    @Column(name="description", nullable=false, length=500)
    private String description;

    @Column(name="start_date", nullable=false)
    private java.sql.Date start_date;

    @CreationTimestamp
    @Column(name="created_at", nullable=false)
    private LocalDate created_at;

    @Column(name="end_date", nullable=false)
    private java.sql.Date end_date;

    @UpdateTimestamp
    @Column(name="updated_at", nullable=false)
    private LocalDate updated_at;

    @Column(name="file_url", nullable=true)
    private String file_url;

    @Column(name="task_title", nullable=false)
    private String task_title;

    @Builder
    public Task(Long list_id, Long project_id, String description, Date start_date, Date end_date, String file_url, String task_title) {
        this.list_id = list_id;
        this.project_id = project_id;
        this.description = description;
        this.start_date = start_date;
        this.created_at = LocalDate.now();
        this.end_date = end_date;
        this.updated_at = LocalDate.now();
        this.file_url = file_url;
        this.task_title = task_title;
    }

    public Task() {

    }
}