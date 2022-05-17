package com.techeer.inforplanbackend.domain.project.dto.Mapper;

import com.techeer.inforplanbackend.domain.project.dto.Request.ProjectRequestDto;
import com.techeer.inforplanbackend.domain.project.dto.Response.ProjectResponseDto;
import com.techeer.inforplanbackend.domain.project.entity.Project;
import com.techeer.inforplanbackend.domain.project.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProjectMapper {

    private final ProjectRepository projectRepository;

    public Project toEntity(ProjectRequestDto projectRequestDto)
    {
        return Project.builder()
                .project_title(projectRequestDto.project_title)
                .url(projectRequestDto.url)
                .meet_date(projectRequestDto.meet_date)
                .build();

    }
    public ProjectResponseDto fromEntity(Project project)
    {
        return ProjectResponseDto.builder()
                .id(project.getId())
                .project_title(project.getProject_title())
                .url(project.getUrl())
                .meet_date(project.getMeet_date())
                .build();
    }
}
