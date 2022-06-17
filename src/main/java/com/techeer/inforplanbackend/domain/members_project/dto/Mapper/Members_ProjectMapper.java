package com.techeer.inforplanbackend.domain.members_project.dto.Mapper;

import com.techeer.inforplanbackend.domain.members_project.dto.Response.Members_ProjectResponseDto;
import com.techeer.inforplanbackend.domain.members_project.entity.Members_Project;
import com.techeer.inforplanbackend.domain.members_project.repository.Members_ProjectRepository;
import com.techeer.inforplanbackend.domain.project.entity.Project;
import com.techeer.inforplanbackend.domain.user.domain.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Members_ProjectMapper {

    private final Members_ProjectRepository members_projectRepository;

    public Members_Project toEntity(Project project, Users user)
    {
        return Members_Project.builder()
                .project(project)
                .users(user)
                .build();

    }

    public Members_ProjectResponseDto fromEntity(Members_Project members_project)
    {
        return Members_ProjectResponseDto.builder()
                .id(members_project.getId())
                .project(members_project.getProject())
                .users(members_project.getUsers())
                .build();
    }
}
