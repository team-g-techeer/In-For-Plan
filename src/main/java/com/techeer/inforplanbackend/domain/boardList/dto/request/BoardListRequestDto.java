package com.techeer.inforplanbackend.domain.boardList.dto.request;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class BoardListRequestDto {

    public String boardList_title;

    public Long project_id;

}
