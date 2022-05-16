package com.techeer.inforplanbackend.domain.project.dto.request;

import com.techeer.inforplanbackend.domain.project.domain.entity.List;
import com.techeer.inforplanbackend.domain.project.domain.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Getter;
import java.sql.Date;


@Getter   //dto에는 setter 사용하면 안됨
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

    public String toString() {
        return "\"list_id\": " + list_id +"\n" +
                "    \"project_id\":" + project_id + "\n" +
                "    \"description\": " + description +",\n" +
                "    \"start_date\":" + start_date + ",\n" +
                "    \"end_date\": " + end_date + ",\n" +
                "    \"file_url\": " +  file_url +",\n" +
                "    \"task_title\": " + task_title;
    }
}
