package com.techeer.inforplanbackend.domain.project.controller;
import com.techeer.inforplanbackend.domain.project.dto.Mapper.ProjectMapper;
import com.techeer.inforplanbackend.domain.project.dto.Request.ProjectRequestDto;
import com.techeer.inforplanbackend.domain.project.dto.Response.ProjectResponseDto;
import com.techeer.inforplanbackend.domain.project.entity.Project;
import com.techeer.inforplanbackend.domain.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
    @RequestMapping("api/v1")
    @RequiredArgsConstructor
    public class ProjectController {

    private final ProjectService projectService;

    private final ProjectMapper projectMapper;
    @PostMapping("/projects")
    public ProjectResponseDto saveProject(@RequestBody ProjectRequestDto dto) throws Exception
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = ((User) auth.getPrincipal()).getUsername();
        System.out.println(email);
        System.out.println(dto.project_title);
        if(email!=null) {
            Project project = projectService.save(dto, email);
            return projectMapper.fromEntity(project);
        }else
        {
            return null;
        }

    }

    @DeleteMapping("/project/{project_id}")
    public ResponseEntity deleteProject(@PathVariable("project_id") Long id)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = ((User) auth.getPrincipal()).getUsername();
        System.out.println("-----------------" +id +"---------------");
        projectService.deleteProject(id,email);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/project/{project_id}")
    public ResponseEntity update(@PathVariable("project_id") Long id,@RequestBody ProjectRequestDto dto)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = ((User)auth.getPrincipal()).getUsername();
        projectService.updateProject(id,email,dto);
        return ResponseEntity.ok(id);

    }

    @GetMapping("/projects/all")
    public List<Project> findall(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = ((User)auth.getPrincipal()).getUsername();
        List<Project> projectlist = projectService.findall(email);
        System.out.println(email+"123124124124124124124124");
        System.out.println(projectlist);
        return projectlist;
    }

    @GetMapping("/projects/{project_id}")
    public Optional<Project> findbyid(@PathVariable("project_id")Long id){

        Optional<Project> project = projectService.findbyid(id);
        return project;
    }

}
