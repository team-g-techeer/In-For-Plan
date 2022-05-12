package com.techeer.inforplanbackend.domain.project.service;

import com.techeer.inforplanbackend.domain.project.dto.Mapper.ProjectMapper;
import com.techeer.inforplanbackend.domain.project.dto.Request.ProjectRequestDto;
import com.techeer.inforplanbackend.domain.project.dto.Response.ProjectResponseDto;
import com.techeer.inforplanbackend.domain.project.entity.Project;
import com.techeer.inforplanbackend.domain.project.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class ProjectService {

    private ProjectRepository projectRepository;
    public final ProjectMapper projectMapper;

    @Transactional
    public Long save(ProjectRequestDto dto)
    {
        Project entity = projectRepository.save(projectMapper.toEntity(dto));
        return entity.getId();
    }

    @Transactional
    public void deleteProject(Long id)
    {
        projectRepository.deleteById(id);
    }

    @Transactional
    public Long updateProject(Long id,ProjectResponseDto dto)
    {
        Project project = projectRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 유저가 없습니다."));

        project.update(dto.getProject_title(),dto.getUrl(),dto.getMeet_date());

        return id;

    }
    @Transactional
    public List<Project> findall()
    {
        return projectRepository.findAll();
    }


}
