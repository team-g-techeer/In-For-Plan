package com.techeer.inforplanbackend.domain.project.dto.mapper;

import com.techeer.inforplanbackend.domain.project.dto.request.ProjectRequestDto;
import com.techeer.inforplanbackend.domain.project.dto.response.ProjectResponseDto;
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
