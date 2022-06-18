package com.techeer.inforplanbackend.domain.members_project.entity;

import com.techeer.inforplanbackend.domain.project.entity.Project;
import com.techeer.inforplanbackend.domain.user.domain.entity.Users;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Members_Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;


    @Builder
    public Members_Project(Long id, Users users, Project project) {
        this.id = id;
        this.users = users;
        this.project = project;
    }

}
