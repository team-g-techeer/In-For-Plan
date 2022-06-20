package com.techeer.inforplanbackend.domain.boardList.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class BoardListResponseDto {

    public Long id;

    public String boardList_title;

}
