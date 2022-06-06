package com.techeer.inforplanbackend.domain.task.controller;


import com.techeer.inforplanbackend.domain.task.dto.mapper.TaskMapper;
import com.techeer.inforplanbackend.domain.task.dto.request.TaskRequestDto;
import com.techeer.inforplanbackend.domain.task.dto.response.TaskResponseDto;
import com.techeer.inforplanbackend.domain.task.entity.Task;
import com.techeer.inforplanbackend.domain.task.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1")
public class TaskController {
    public final TaskService taskService;
    public final TaskMapper taskMapper;

    @PostMapping("/tasks")
    public TaskResponseDto create(@RequestBody TaskRequestDto taskRequestDto) {
        Task task = taskService.create(taskRequestDto);
        return taskMapper.fromEntity(task);
    }

    @GetMapping
    public List<Task> all() {
        List<Task> task = taskService.all();
        return task;
    }

    @DeleteMapping("/tasks/{task_id}")
    public String delete(@PathVariable Long task_id) {
        taskService.deleteById(task_id);
        return "삭제된 task의 id : " + task_id;
    }

    @GetMapping("/tasks/{task_id}")
    public TaskResponseDto find(@PathVariable Long task_id) {
        return taskService.findById(task_id);
    }

    @PutMapping("/tasks/{task_id}")
    public TaskResponseDto update(@PathVariable Long task_id, @RequestBody TaskRequestDto taskRequestDto) {
        taskService.update(task_id, taskRequestDto);
        return taskService.findById(task_id);
    }
}
