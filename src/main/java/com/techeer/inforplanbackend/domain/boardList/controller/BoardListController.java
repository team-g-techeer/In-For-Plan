package com.techeer.inforplanbackend.domain.boardList.controller;

import com.techeer.inforplanbackend.domain.boardList.dto.Mapper.BoardListMapper;
import com.techeer.inforplanbackend.domain.boardList.dto.Request.BoardListRequestDto;
import com.techeer.inforplanbackend.domain.boardList.dto.Response.BoardListResponseDto;
import com.techeer.inforplanbackend.domain.boardList.entity.BoardList;
import com.techeer.inforplanbackend.domain.boardList.service.BoardListService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class BoardListController {

    private BoardListService boardListService;
    private BoardListMapper boardListMapper;

    @PostMapping("/boardLists")
    public BoardListResponseDto saveBoardList(@RequestBody BoardListRequestDto dto){
        BoardList boardList = boardListService.save(dto);
        return boardListMapper.fromEntity(boardList);
    }
}
