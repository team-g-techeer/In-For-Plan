package com.techeer.inforplanbackend.domain.project.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Getter //클래스내의 모든 필드의 Getter 메소드를 생성
@Entity //테이블과 링크될 클래스임을 나타냄
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자 자동 추가, 기본 생성자의 접근 권한을 protected로 제한

public class Project extends BaseTimeEntity {

    @Id @GeneratedValue //@Id:해당 테이블의 pk임을 나타냄 @GeneratedValue : PK의 생성 규칙을 나타냄
    @Column(name= "id")
    private Long id;

    @Column(name = "project_title", nullable = false)
    private String project_title;

//    @Column(name = "created_at")
//    private String created_at;
//
//    @Column(name = "updated_at")
//    private String updated_at;
//
      @Column(name = "url", nullable = false)
      private String url;
//
      @Column(name = "meet_date") //yyyy-mm-dd
      private Date meet_date;

    @Builder
    public Project(String project_title,String url,Date meet_date)
    {
        this.project_title = project_title;
        this.url = url;
        this.meet_date = meet_date;
    }

    public void update(String project_title,String url,Date meet_date)
    {
        this.project_title = project_title;
        this.url = url;
        this.meet_date = meet_date;
    }

}
