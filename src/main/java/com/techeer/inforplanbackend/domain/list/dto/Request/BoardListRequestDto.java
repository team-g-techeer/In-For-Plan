package com.techeer.inforplanbackend.domain.list.dto.Request;

import com.techeer.inforplanbackend.domain.project.domain.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardListRequestDto {

    @Size(max = 200)
    private String List_title;
}
