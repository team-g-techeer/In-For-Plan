package com.techeer.inforplanbackend.domain.project.controller;
import com.techeer.inforplanbackend.domain.project.dto.Request.ProjectRequestDto;
import com.techeer.inforplanbackend.domain.project.dto.Response.ProjectResponseDto;
import com.techeer.inforplanbackend.domain.project.entity.Project;
import com.techeer.inforplanbackend.domain.project.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class ProjectController {

    private ProjectService projectService;

    @PostMapping("/projects")
    public Long saveProject(@RequestBody ProjectRequestDto dto)
    {
        return projectService.save(dto);
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

    @GetMapping ("/test")
    public String TEST()
    {
        return "Hello";
    }
}
