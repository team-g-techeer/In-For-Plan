package com.techeer.inforplanbackend.domain.members_project.dto.Mapper;

import com.techeer.inforplanbackend.domain.members_project.dto.Request.Members_ProjectRequestDto;
import com.techeer.inforplanbackend.domain.members_project.dto.Response.Members_ProjectResponseDto;
import com.techeer.inforplanbackend.domain.members_project.entity.Members_Project;
import com.techeer.inforplanbackend.domain.members_project.repository.Members_ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Members_ProjectMapper {

    public Members_Project toEntity(Members_ProjectRequestDto dto)
    {
        return Members_Project.builder()
                .project(dto.project)
                .users(dto.users)
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
