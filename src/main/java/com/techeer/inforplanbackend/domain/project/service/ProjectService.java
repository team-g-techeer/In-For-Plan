package com.techeer.inforplanbackend.domain.project.service;

import com.techeer.inforplanbackend.domain.members_project.dto.Mapper.Members_ProjectMapper;
import com.techeer.inforplanbackend.domain.members_project.entity.Members_Project;
import com.techeer.inforplanbackend.domain.members_project.repository.Members_ProjectRepository;
import com.techeer.inforplanbackend.domain.project.dto.Mapper.ProjectMapper;
import com.techeer.inforplanbackend.domain.project.dto.Request.ProjectRequestDto;
import com.techeer.inforplanbackend.domain.project.entity.Project;
import com.techeer.inforplanbackend.domain.project.repository.ProjectRepository;
import com.techeer.inforplanbackend.domain.user.domain.entity.Users;
import com.techeer.inforplanbackend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@EnableWebSecurity
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    public final ProjectMapper projectMapper;
    public final UserRepository userRepository;
    private final Members_ProjectRepository members_projectRepository;
    @Autowired
    private final Members_ProjectMapper members_projectMapper;
    @Autowired
    private Members_Project members_project;
    @Transactional
    public Project save(ProjectRequestDto dto, String email) {
        Users user = userRepository.findByEmail(email).orElseThrow(() ->
                new IllegalArgumentException("해당 유저가 없습니다."));
        Project project = projectRepository.save(projectMapper.toEntity(dto));
        members_projectRepository.save(members_projectMapper.toEntity(project, user));

        return project;


    }

    @Transactional
    public void deleteProject(Long id,String email) {
        Users user = userRepository.findByEmail(email).orElseThrow(()->
                new IllegalArgumentException("해당 유저가 없습니다."));
        Project project = projectRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 프로젝트가 없습니다."));
        members_project = members_projectRepository.findMembers_ProjectByProject(project);
        System.out.println(members_project);
        members_projectRepository.delete(members_project);
        projectRepository.deleteById(id);
    }

    @Transactional
    public Long updateProject(Long id,String email,ProjectRequestDto dto) {
        Users user = userRepository.findByEmail(email).orElseThrow(()->
                new IllegalArgumentException("해당 유저가 없습니다."));
        Project project = projectRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 프로젝트가 없습니다."));

        project.update(dto.getProject_title(),dto.getUrl(),dto.getMeet_date());
        members_project.update(user,project);
        return id;



    }

    @Transactional
    public List<Project> findall(String email)
    {
        Users user = userRepository.findByEmail(email).orElseThrow(()->
                new IllegalArgumentException("해당 유저가 없습니다."));
        System.out.println("-----------------------"+user.getEmail());
        List<Members_Project> memberlist = members_projectRepository.findMembers_ProjectByUsers(user);
        List<Project> projectlist = new ArrayList<Project>();
        for(int i=0;i<memberlist.size();i++)
        {
            projectlist.add(memberlist.get(i).getProject());
        }
        return projectlist;
    }

    @Transactional
    public Optional<Project> findbyid(Long id) {
        try {
            Optional<Project> result = projectRepository.findById(id);
            if (result.isPresent()) {
                return result;
            } else {
                return Optional.ofNullable(result.orElse(null));
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid Request");
        }
    }


}
