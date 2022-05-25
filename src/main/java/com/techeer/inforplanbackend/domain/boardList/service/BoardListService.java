package com.techeer.inforplanbackend.domain.boardList.service;

import com.techeer.inforplanbackend.domain.boardList.dto.Mapper.BoardListMapper;
import com.techeer.inforplanbackend.domain.boardList.dto.Request.BoardListRequestDto;
import com.techeer.inforplanbackend.domain.boardList.entity.BoardList;
import com.techeer.inforplanbackend.domain.boardList.repository.BoardListRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BoardListService {

    private final BoardListRepository boardListRepository;
    public final BoardListMapper boardListMapper;

    @Transactional
    public BoardList save(BoardListRequestDto dto){

        return boardListRepository.save(boardListMapper.toEntity(dto));
    }


}
