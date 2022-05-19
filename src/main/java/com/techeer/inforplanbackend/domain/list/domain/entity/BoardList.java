package com.techeer.inforplanbackend.domain.list.domain.entity;

import com.techeer.inforplanbackend.domain.project.domain.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@AllArgsConstructor
public class BoardList extends BaseTimeEntity{
    @Id
    @GeneratedValue
    @Column(name = "listId")
    private Long listId;

//    @ManyToOne
//    @JoinColumn(name = "project_id")
//    private Project project;

    private String boardList_title;

    @Builder
    public BoardList(String list_title, Date created_at, Date updated_at, Project project) {
        this.boardList_title = list_title;
//        this.project = project;
    }

    public void update(String boardList_title){
        this.boardList_title = boardList_title;
    }
}
