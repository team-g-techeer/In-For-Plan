package com.techeer.inforplanbackend.domain.project.service;

import com.techeer.inforplanbackend.domain.project.entity.Project;
import com.techeer.inforplanbackend.domain.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> findAll(){
        List<Project> projects = new ArrayList<>();
        projectRepository.findAll().forEach(e->projects.add(e));
        return projects;
    }

    public Optional<Project> findById(Long p_id){
        Optional<Project> projects = projectRepository.findById(p_id);
        return projects;
    }

    public void deleteById(Long p_id){
        projectRepository.deleteById(p_id);
    }

    public Project save(Project project){
        projectRepository.save(project);
        return project;
    }

}
