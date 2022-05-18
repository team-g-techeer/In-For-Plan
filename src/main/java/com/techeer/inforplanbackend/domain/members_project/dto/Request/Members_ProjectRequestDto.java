package com.techeer.inforplanbackend.domain.members_project.dto.Request;

import com.techeer.inforplanbackend.domain.project.entity.Project;
import com.techeer.inforplanbackend.domain.user.domain.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class Members_ProjectRequestDto {

    public Project project;
    public Users users;
}
