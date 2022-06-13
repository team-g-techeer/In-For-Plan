package com.techeer.inforplanbackend.domain.boardList.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@AllArgsConstructor
public class BoardListRequestDto {

    public String boardList_title;

    public Long project_id;

}
