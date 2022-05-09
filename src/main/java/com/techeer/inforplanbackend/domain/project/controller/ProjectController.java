package com.techeer.inforplanbackend.domain.project.controller;

import com.techeer.inforplanbackend.domain.project.domain.entity.Project;
import com.techeer.inforplanbackend.domain.project.domain.repository.ProjectRepository;
import com.techeer.inforplanbackend.domain.project.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("projects")
public class ProjectController {

    ProjectService projectService;
    @GetMapping(value = "/{p-id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Project>> getAllprojects(){
        List<Project> projects = projectService.findAll();
        return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
    }




}
