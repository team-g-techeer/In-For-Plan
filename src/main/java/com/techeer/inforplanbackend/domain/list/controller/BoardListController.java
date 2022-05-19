package com.techeer.inforplanbackend.domain.list.controller;

import com.techeer.inforplanbackend.domain.list.domain.entity.BoardList;
import com.techeer.inforplanbackend.domain.list.dto.Mapper.BoardListMapper;
import com.techeer.inforplanbackend.domain.list.dto.Request.BoardListRequestDto;
import com.techeer.inforplanbackend.domain.list.dto.Response.BoardListResponseDto;
import com.techeer.inforplanbackend.domain.list.service.BoardListService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;



@RestController
@RequestMapping("api/v1/projects/lists")
@AllArgsConstructor
public class BoardListController {


    @Autowired
    private BoardListService boardListService;
    @Autowired
    private BoardListMapper boardlistMapper;

    @GetMapping
    public ResponseEntity<List<BoardListResponseDto>> getList() {
        List<BoardListResponseDto>  entityList = boardListService.findAll()
                .stream()
                .map(BoardListMapper::fromEntity)
                .collect(Collectors.toList());

        return ResponseEntity
                .ok()
                .body(entityList);
    }

    @PostMapping
    public BoardListResponseDto create(@Validated @RequestBody BoardListRequestDto boardListRequestDto) {
        BoardList boardList = boardListService.create(boardListRequestDto);
        return boardlistMapper.fromEntity(boardList);
    }

    @PutMapping("/{listId}")
    public ResponseEntity update(@PathVariable Long listId, @Valid @RequestBody BoardListResponseDto dto) {
        boardListService.update(listId, dto);
        return ResponseEntity
                .ok(listId);
    }

    @DeleteMapping("/{listId}")
    public ResponseEntity<Void> delete(@PathVariable Long listId) {

        boardListService.delete(listId);
        return ResponseEntity
                .ok()
                .body(null);
    }
}



