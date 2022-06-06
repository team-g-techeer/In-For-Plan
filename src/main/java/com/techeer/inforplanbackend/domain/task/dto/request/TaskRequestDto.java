package com.techeer.inforplanbackend.domain.task.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class TaskRequestDto {
    public Long list_id;

    public Long project_id;

    public String description;

    public java.sql.Date start_date;

    public java.sql.Date end_date;

    public String file_url;

    public String task_title;
}
