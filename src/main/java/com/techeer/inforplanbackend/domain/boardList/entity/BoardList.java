package com.techeer.inforplanbackend.domain.boardList.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.techeer.inforplanbackend.domain.project.entity.Project;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor
@JsonAutoDetect
public class BoardList extends  BaseTimeEntity{

    @Id
    @GeneratedValue
    @Column(name = "boardList_id")
    private Long id;

    @Column(name = "boardList_title", nullable = false)
    private String boardList_title;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Builder
    public BoardList(String boardList_title, Project project){
        this.boardList_title = boardList_title;
        this.project = project;
    }

    public void update(String boardList_title){
        this.boardList_title = boardList_title;
    }
}
