package com.techeer.inforplanbackend.domain.project.service;

import com.techeer.inforplanbackend.domain.project.domain.entity.Project;
import com.techeer.inforplanbackend.domain.project.domain.repository.ProjectRepository;
import com.techeer.inforplanbackend.domain.project.dto.ProjectDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    @Transactional
    public Long save(ProjectDto dto)
    {
        Project entity = projectRepository.save(dto.toEntity());
        return entity.getId();
    }

    @Transactional
    public void deleteProject(Long id)
    {
        projectRepository.deleteById(id);
    }

    @Transactional
    public Long updateProject(Long id,ProjectDto dto)
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
