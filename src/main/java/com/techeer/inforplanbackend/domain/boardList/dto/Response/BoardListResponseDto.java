package com.techeer.inforplanbackend.domain.boardList.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BoardListResponseDto {

    public Long id;
    public String boardList_title;
}
