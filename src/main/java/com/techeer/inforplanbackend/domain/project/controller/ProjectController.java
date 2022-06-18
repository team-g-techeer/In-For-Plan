package com.techeer.inforplanbackend.domain.project.controller;

import com.techeer.inforplanbackend.domain.project.dto.mapper.ProjectMapper;
import com.techeer.inforplanbackend.domain.project.dto.request.ProjectRequestDto;
import com.techeer.inforplanbackend.domain.project.dto.response.ProjectResponseDto;
import com.techeer.inforplanbackend.domain.project.entity.Project;
import com.techeer.inforplanbackend.domain.project.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class ProjectController {

    private ProjectService projectService;
    private ProjectMapper projectMapper;

    @PostMapping("/projects")
    public ProjectResponseDto saveProject(@RequestBody ProjectRequestDto dto) {
        Project project = projectService.save(dto);
        return projectMapper.fromEntity(project);
    }

    @DeleteMapping("/projects/{project_id}")
    public ResponseEntity deleteProject(@PathVariable("project_id") Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/projects/{project_id}")
    public ResponseEntity update(@PathVariable("project_id") Long id, @RequestBody ProjectResponseDto dto) {
        projectService.updateProject(id, dto);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/projects/all")
    public List<Project> findAll() {
        return projectService.findAll();
    }

    @GetMapping("/projects/{project_id}")
    public Optional<Project> findById(@PathVariable("project_id") Long id) {
        return projectService.findbyId(id);
    }

}
