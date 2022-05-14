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
                .created_at(dto.getCreated_at())
                .updated_at(dto.getUpdated_at())
                .build();
    }

    public static BoardListResponseDto fromEntity(BoardList entity){
        return BoardListResponseDto.builder()
                .list_title(entity.getList_title())
                .created_at(entity.getCreated_at())
                .updated_at(entity.getUpdated_at())
                .build();
    }
}
