package com.techeer.inforplanbackend.domain.project.dto.mapper;

import com.techeer.inforplanbackend.domain.project.domain.entity.Task;
import com.techeer.inforplanbackend.domain.project.dto.response.TaskResponseDto;
import com.techeer.inforplanbackend.domain.project.repository.TaskRepository;
import com.techeer.inforplanbackend.domain.project.dto.request.TaskRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskMapper {

    private final TaskRepository taskRepository;

    public Task toEntity(TaskRequestDto taskRequestDto) {  //요청받은 DTO(requestDto)로부터 엔티티로 값을 줌
        return Task.builder()
                .list_id(taskRequestDto.list_id)
                .project_id(taskRequestDto.project_id)
                .description(taskRequestDto.description)
                .start_date(taskRequestDto.start_date)
                .end_date(taskRequestDto.end_date)
                .file_url(taskRequestDto.file_url)
                .task_title(taskRequestDto.task_title)
                .build();
    }

    public TaskResponseDto fromEntity(Task task) {  //엔티티로부터 응답 DTO(responseDto)로 값을 가져온다
        return TaskResponseDto.builder()
                .task_id(task.getTask_id())
                .list_id(task.getList_id())
                .project_id(task.getProject_id())
                .description(task.getDescription())
                .start_date(task.getStart_date())
                .end_date(task.getEnd_date())
                .created_at(task.getCreated_at())
                .updated_at(task.getUpdated_at())
                .file_url(task.getFile_url())
                .task_title(task.getTask_title())
                .build();
    }
}
