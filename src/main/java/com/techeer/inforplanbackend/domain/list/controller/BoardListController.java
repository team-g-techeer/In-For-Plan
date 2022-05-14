package com.techeer.inforplanbackend.domain.list.controller;

import com.techeer.inforplanbackend.domain.list.domain.entity.BoardList;
import com.techeer.inforplanbackend.domain.list.dto.Mapper.BoardListMapper;
import com.techeer.inforplanbackend.domain.list.dto.Request.BoardListRequestDto;
import com.techeer.inforplanbackend.domain.list.dto.Response.BoardListResponseDto;
import com.techeer.inforplanbackend.domain.list.service.BoardListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;



@RestController
@RequestMapping("api/v1/projects/{project-id}/lists")
@RequiredArgsConstructor
public class BoardListController {

    private final BoardListService boardListService;
    private final BoardListMapper boardlistMapper;

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

//
//    @PostMapping
//    public ResponseEntity<BoardListResponseDto> create(@Valid @RequestBody BoardListRequestDto requestDto) {
//
//        BoardList entity = boardListService.create(boardlistMapper.toEntity(requestDto));
//
////        return boardlistMapper.fromEntity(entity);
//        return ResponseEntity
//                .created(WebMvcLinkBuilder
//                        .linkTo(this.getClass())
//                        .slash(entity.getList_id())
//                        .toUri()
//                )
//                .body(boardlistMapper.fromEntity(entity));
//    }

}
