package com.techeer.inforplanbackend.domain.task.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class TaskResponseDto {
    public Long task_id;

    public Long list_id;

    public Long project_id;

    public String description;

    public java.sql.Date start_date;

    public java.sql.Date end_date;

    public LocalDate created_at;

    public LocalDate updated_at;

    public String file_url;

    public String task_title;

}
