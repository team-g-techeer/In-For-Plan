package com.techeer.inforplanbackend.domain.project.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
public class ProjectRequestDto {

    public String project_title;
    public String url;
    public Date meet_date;


}
