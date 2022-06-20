package com.techeer.inforplanbackend.domain.boardList.dto.mapper;

import com.techeer.inforplanbackend.domain.boardList.dto.request.BoardListRequestDto;
import com.techeer.inforplanbackend.domain.boardList.dto.response.BoardListResponseDto;
import com.techeer.inforplanbackend.domain.boardList.entity.BoardList;
import com.techeer.inforplanbackend.domain.boardList.repository.BoardListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BoardListMapper {

    private final BoardListRepository boardListRepository;

    public BoardList toEntity(BoardListRequestDto boardListRequestDto){
        return BoardList.builder()
                .boardList_title(boardListRequestDto.boardList_title)
                .build();
    }

    public BoardListResponseDto fromEntity(BoardList boardList){
        return BoardListResponseDto.builder()
                .id(boardList.getId())
                .boardList_title(boardList.getBoardList_title())
                .build();
    }
}
