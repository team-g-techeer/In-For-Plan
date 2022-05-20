package com.techeer.inforplanbackend.domain.project.controller;

import com.techeer.inforplanbackend.domain.project.domain.entity.Task;
import com.techeer.inforplanbackend.domain.project.dto.mapper.TaskMapper;
import com.techeer.inforplanbackend.domain.project.dto.request.TaskRequestDto;
import com.techeer.inforplanbackend.domain.project.dto.response.TaskResponseDto;
import com.techeer.inforplanbackend.domain.project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/projects/{project-id}", method={RequestMethod.GET, RequestMethod.POST})
public class TaskController {
    @Autowired public TaskService taskService;
    @Autowired public TaskMapper taskMapper;

    @PostMapping("/tasks")   //test not ok
    @ResponseBody
    public TaskResponseDto create(@RequestBody TaskRequestDto taskRequestDto) {
        Task task = taskService.create(taskRequestDto);
        return taskMapper.fromEntity(task);
    }

    @GetMapping
    @ResponseBody
    public List<Task> all() {    //test ok
        List<Task> tasks = taskService.all();
        return tasks;
    }


//    @GetMapping("/api")   //test ok
//    @ResponseBody
//    public String test() {
//        return "hello world";
//    }
}
