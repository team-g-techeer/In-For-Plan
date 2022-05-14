package com.techeer.inforplanbackend.domain.list.domain.entity;

import com.techeer.inforplanbackend.domain.project.domain.entity.Project;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@NoArgsConstructor
public class BoardList {
    @Id
    @GeneratedValue
    @Column(name = "list_id")
    private Long list_id;

//    @ManyToOne
//    @JoinColumn(name = "project_id")
//    private Project project;

    private String list_title;

    private Date created_at;

    private Date updated_at;

    @Builder
    public BoardList(String list_title, Date created_at, Date updated_at, Project project) {
        this.list_title = list_title;
        this.created_at =created_at;
        this.updated_at = updated_at;
//        this.project = project;
    }
}
