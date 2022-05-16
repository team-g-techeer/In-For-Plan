package com.techeer.inforplanbackend.domain.project.controller;

import com.techeer.inforplanbackend.domain.project.domain.entity.Task;
import com.techeer.inforplanbackend.domain.project.dto.mapper.TaskMapper;
import com.techeer.inforplanbackend.domain.project.dto.request.TaskRequestDto;
import com.techeer.inforplanbackend.domain.project.dto.response.TaskResponseDto;
import com.techeer.inforplanbackend.domain.project.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {
    public TaskService taskService;
    public TaskMapper taskMapper;

    @PostMapping(value = "/test")
    @ResponseBody
    public TaskResponseDto save(@RequestBody TaskRequestDto taskRequestDto) {
        Task task = taskService.create(taskRequestDto);

        return taskMapper.fromEntity(task);
    }



}
