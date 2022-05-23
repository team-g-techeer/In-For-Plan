package com.techeer.inforplanbackend.domain.project.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter   //Dto엔 getter 안됨
@Builder
@AllArgsConstructor    //클래스에 존재하는 모든 필드에 대한 생성자를 자동으로 생성해줌
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
