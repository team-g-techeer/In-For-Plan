package com.techeer.inforplanbackend.domain.project.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
public class ProjectResponseDto {

    public Long id;
    public String project_title;
    public String url;
    public Date meet_date;

}
