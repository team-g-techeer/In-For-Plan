package com.techeer.inforplanbackend.domain.project.entity;

import com.techeer.inforplanbackend.domain.members_project.entity.Members_Project;
import com.techeer.inforplanbackend.domain.user.domain.entity.Users;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Getter //클래스내의 모든 필드의 Getter 메소드를 생성
@Entity //테이블과 링크될 클래스임을 나타냄
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자 자동 추가, 기본 생성자의 접근 권한을 protected로 제한

public class Project extends BaseTimeEntity {

    @Id @GeneratedValue //@Id:해당 테이블의 pk임을 나타냄 @GeneratedValue : PK의 생성 규칙을 나타냄
    @Column(name= "project_id")
    private Long id;

    @Column(name = "project_title", nullable = false)
    private String project_title;

    @Column(name = "url", nullable = false)
      private String url;

    @Column(name = "meet_date") //yyyy-mm-dd
      private Date meet_date;

    @OneToMany(mappedBy = "project")
    private List<Members_Project> Members_project = new ArrayList<Members_Project>();


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
