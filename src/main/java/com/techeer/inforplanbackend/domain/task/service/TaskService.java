package com.techeer.inforplanbackend.domain.task.service;

import com.techeer.inforplanbackend.domain.task.dto.mapper.TaskMapper;
import com.techeer.inforplanbackend.domain.task.dto.request.TaskRequestDto;
import com.techeer.inforplanbackend.domain.task.dto.response.TaskResponseDto;
import com.techeer.inforplanbackend.domain.task.entity.Task;
import com.techeer.inforplanbackend.domain.task.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    @Autowired private TaskRepository taskRepository;
    private TaskMapper taskMapper;

    @Transactional
    public Task create(TaskRequestDto taskRequestDto) {
        return taskRepository.save(taskMapper.toEntity(taskRequestDto));
    }

    @Transactional
    public List<Task> all() {
        return taskRepository.findAll();
    }

    @Transactional
    public void deleteById(Long task_id) {
        taskRepository.deleteById(task_id);
    }

    @Transactional
    public TaskResponseDto findById(Long task_id) {
        Task task = taskRepository.findById(task_id)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 task가 없습니다."));
        return taskMapper.fromEntity(task);
    }

    @Transactional
    public void update(Long task_id, TaskRequestDto taskRequestDto) {
        Task task = taskRepository.findById(task_id).orElseThrow(() -> new IllegalArgumentException("해당하는 task가 없습니다."));

        task.update(taskRequestDto.getList_id(), taskRequestDto.getDescription(), taskRequestDto.getStart_date(),
                taskRequestDto.getEnd_date(), taskRequestDto.getFile_url(), taskRequestDto.getTask_title());
    }

}
