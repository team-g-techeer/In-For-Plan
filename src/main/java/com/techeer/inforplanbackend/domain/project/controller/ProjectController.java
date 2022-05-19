package com.techeer.inforplanbackend.domain.project.controller;
import com.techeer.inforplanbackend.domain.project.dto.Mapper.ProjectMapper;
import com.techeer.inforplanbackend.domain.project.dto.Request.ProjectRequestDto;
import com.techeer.inforplanbackend.domain.project.dto.Response.ProjectResponseDto;
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
public class    ProjectController {

    private ProjectService projectService;
    private ProjectMapper projectMapper;
    @PostMapping("/projects")
    public ProjectResponseDto saveProject(@RequestBody ProjectRequestDto dto)
    {
        Project project = projectService.save(dto);
        return projectMapper.fromEntity(project);
    }

    @DeleteMapping("/projects/{project_id}")
    public ResponseEntity deleteProject(@PathVariable("project_id") Long id)
    {
        projectService.deleteProject(id);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/projects/{project_id}")
    public ResponseEntity update(@PathVariable("project_id")Long id, @RequestBody ProjectResponseDto dto)
    {
        projectService.updateProject(id, dto);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/projects/all")
    public List<Project> findall(){
        List<Project> all = projectService.findall();
        return all;
    }

    @GetMapping("/projects/{project_id}")
    public Optional<Project> findbyid(@PathVariable("project_id")Long id){

        Optional<Project> project = projectService.findbyid(id);
        return project;
    }

}
