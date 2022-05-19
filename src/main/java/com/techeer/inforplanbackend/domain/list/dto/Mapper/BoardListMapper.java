package com.techeer.inforplanbackend.domain.list.dto.Mapper;

import com.techeer.inforplanbackend.domain.list.domain.entity.BoardList;
import com.techeer.inforplanbackend.domain.list.dto.Request.BoardListRequestDto;
import com.techeer.inforplanbackend.domain.list.dto.Response.BoardListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BoardListMapper {

    public BoardList toEntity(BoardListRequestDto dto){
        return BoardList.builder()
                .list_title(dto.getList_title())
                .build();
    }

    public static BoardListResponseDto fromEntity(BoardList entity){
        return BoardListResponseDto.builder()
                .list_title(entity.getBoardList_title())
                .build();
    }
}
