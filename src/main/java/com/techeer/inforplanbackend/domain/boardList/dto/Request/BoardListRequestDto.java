package com.techeer.inforplanbackend.domain.boardList.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardListRequestDto {

    public String boardList_title;
}
