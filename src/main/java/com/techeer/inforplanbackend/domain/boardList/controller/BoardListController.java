package com.techeer.inforplanbackend.domain.boardList.controller;

import com.techeer.inforplanbackend.domain.boardList.dto.Mapper.BoardListMapper;
import com.techeer.inforplanbackend.domain.boardList.dto.Request.BoardListRequestDto;
import com.techeer.inforplanbackend.domain.boardList.dto.Response.BoardListResponseDto;
import com.techeer.inforplanbackend.domain.boardList.entity.BoardList;
import com.techeer.inforplanbackend.domain.boardList.service.BoardListService;
import com.techeer.inforplanbackend.domain.project.entity.Project;
import com.techeer.inforplanbackend.domain.project.service.ProjectService;
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
    private ProjectService projectService;

    @PostMapping("/boardLists")
    public BoardListResponseDto saveBoardList(@RequestBody BoardListRequestDto dto){

        BoardList boardList = boardListService.save(dto);
        return boardListMapper.fromEntity(boardList);
    }

    @GetMapping("/boardLists")
    public List<BoardList> findall(){
        List<BoardList> all = boardListService.findall();
        return all;
    }

    @GetMapping("/boardLists/{boardList_id}")
    public Optional<BoardList> findbyid(@PathVariable("boardList_id")Long id){

        Optional<BoardList> boardList = boardListService.findbyid(id);
        return boardList;
    }

    @DeleteMapping("/boardLists/{boardList-id}")
    public ResponseEntity deleteBoardList(@PathVariable("boardList-id") Long id){
        boardListService.deleteBoardList(id);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/boardLists/{boardList-id}")
    public ResponseEntity update(@PathVariable("boardList-id")Long id, @RequestBody BoardListResponseDto dto){
        boardListService.updateBoardList(id, dto);
        return ResponseEntity.ok(id);
    }

}
