package com.techeer.inforplanbackend.domain.project.dto;
import com.techeer.inforplanbackend.domain.project.domain.entity.Project;
import lombok.*;

import java.sql.Date;
@Setter
@Getter
@NoArgsConstructor
public class ProjectDto {

//    private String created_at;
    private Date meet_date;
    private String project_title;
    private String url;
//    private String updated_at;


    @Builder
    public ProjectDto(String project_title,Date meet_date,String url)
    {
        this.project_title=project_title;
//        this.updated_at=updated_at;
//        this.created_at=created_at;
        this.meet_date=meet_date;
        this.url=url;
    }


    public Project toEntity(){
        return Project.builder()
                .project_title(project_title)
                .url(url)
                .meet_date(meet_date)
                .build();
    }



}
