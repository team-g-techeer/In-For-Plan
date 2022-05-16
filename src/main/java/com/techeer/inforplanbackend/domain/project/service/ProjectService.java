package com.techeer.inforplanbackend.domain.project.service;

import com.techeer.inforplanbackend.domain.project.dto.Mapper.ProjectMapper;
import com.techeer.inforplanbackend.domain.project.dto.Request.ProjectRequestDto;
import com.techeer.inforplanbackend.domain.project.dto.Response.ProjectResponseDto;
import com.techeer.inforplanbackend.domain.project.entity.Project;
import com.techeer.inforplanbackend.domain.project.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    public final ProjectMapper projectMapper;

    @Transactional
    public Project save(ProjectRequestDto dto)
    {
        return projectRepository.save(projectMapper.toEntity(dto));

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
    @Transactional
    public Optional<Project> findbyid(Long id)
    {
        try{
            Optional<Project> result = projectRepository.findById(id);
            if(result.isPresent())
            {
                return result;
            }else
            {
                return Optional.ofNullable(result.orElse(null));
            }
        }catch (Exception e)
        {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Invalid Request");
        }
    }


}
