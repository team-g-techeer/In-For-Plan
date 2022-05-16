package com.techeer.inforplanbackend.domain.project.service;

import com.techeer.inforplanbackend.domain.project.domain.entity.Task;
import com.techeer.inforplanbackend.domain.project.dto.mapper.TaskMapper;
import com.techeer.inforplanbackend.domain.project.dto.request.TaskRequestDto;
import com.techeer.inforplanbackend.domain.project.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class TaskService {
    public final TaskRepository taskRepository;
    public final TaskMapper taskMapper;

    @Transactional
    public Task create(TaskRequestDto taskRequestDto) {
        return taskRepository.save(taskMapper.toEntity(taskRequestDto));
    }

}
