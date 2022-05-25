package com.techeer.inforplanbackend.domain.boardList.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.techeer.inforplanbackend.domain.boardList.dto.Request.BoardListRequestDto;
import com.techeer.inforplanbackend.domain.project.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect
public class BoardList extends  BaseTimeEntity{

    @Id
    @GeneratedValue
    @Column(name = "boardList_id")
    private Long id;

    @Column(name = "boardList_title", nullable = false)
    private String boardList_title;

//    @ManyToOne
//    @JoinColumn(name = "project_id")
//    private Project project;

    @Builder
    public BoardList(String boardList_title){
        this.boardList_title = boardList_title;
    }

    public void update(String boardList_title){
        this.boardList_title = boardList_title;
    }
}
