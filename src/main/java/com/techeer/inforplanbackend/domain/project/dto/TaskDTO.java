package com.techeer.inforplanbackend.domain.project.dto;

import java.time.LocalDate;

public class TaskDTO {
    private long task_id;
    private long list_id;
    private long project_id;
    private String description;
    private java.sql.Date start_date;
    private java.sql.Date end_date;
    private LocalDate created_at;
    private LocalDate updated_at;
    private String file_url;
    private String task_title;

    public TaskDTO(long task_id, long list_id, long project_id, String description,
                   java.sql.Date start_date, java.sql.Date end_date, String file_url, String task_title) {
        this.task_id = task_id;
        this.list_id = list_id;
        this.project_id = project_id;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.created_at = LocalDate.now();
        this.updated_at = LocalDate.now();
        this.file_url = file_url;
        this.task_title = task_title;
    }
}
