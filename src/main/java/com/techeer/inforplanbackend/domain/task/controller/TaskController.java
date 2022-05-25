package com.techeer.inforplanbackend.domain.project.controller;

import com.techeer.inforplanbackend.domain.project.domain.entity.Task;
import com.techeer.inforplanbackend.domain.project.dto.mapper.TaskMapper;
import com.techeer.inforplanbackend.domain.project.dto.request.TaskRequestDto;
import com.techeer.inforplanbackend.domain.project.dto.response.TaskResponseDto;
import com.techeer.inforplanbackend.domain.project.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/projects/{project_id}", method={RequestMethod.GET, RequestMethod.POST})
public class TaskController {
    public final TaskService taskService;
    public final TaskMapper taskMapper;

    @PostMapping("/tasks")   //test ok
    @ResponseBody
    public TaskResponseDto create(@RequestBody TaskRequestDto taskRequestDto) {
        Task task = taskService.create(taskRequestDto);
        return taskMapper.fromEntity(task);
    }

    @GetMapping
    @ResponseBody
    public List<Task> all() {    //test ok
        List<Task> task = taskService.all();
        return task;
    }

    @DeleteMapping("/tasks/{task_id}")
    @ResponseBody
    public String delete(@PathVariable Long task_id) {
        taskService.deleteById(task_id);
        return "삭제된 task의 id : " + task_id;
    }

    @GetMapping("/tasks/2/{task_id}")
    @ResponseBody
    public TaskResponseDto find(@PathVariable Long task_id) {
        return taskService.findById(task_id);
    }

    @PutMapping("/tasks/3/{task_id}")
    @ResponseBody
    public TaskResponseDto update(@PathVariable Long task_id, @RequestBody TaskRequestDto taskRequestDto) {
        taskService.update(task_id, taskRequestDto);
        return taskService.findById(task_id);
    }
}
