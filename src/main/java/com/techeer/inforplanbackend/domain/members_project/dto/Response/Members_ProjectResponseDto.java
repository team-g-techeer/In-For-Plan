package com.techeer.inforplanbackend.domain.members_project.dto.Response;

import com.techeer.inforplanbackend.domain.project.entity.Project;
import com.techeer.inforplanbackend.domain.user.domain.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Members_ProjectResponseDto {

    public Long id;
    public Project project;
    public Users users;
}
