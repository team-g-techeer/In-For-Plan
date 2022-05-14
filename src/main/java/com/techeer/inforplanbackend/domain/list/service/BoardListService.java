package com.techeer.inforplanbackend.domain.list.service;

import com.techeer.inforplanbackend.domain.list.domain.entity.BoardList;
import com.techeer.inforplanbackend.domain.list.domain.repository.BoardListRepository;
import com.techeer.inforplanbackend.domain.list.dto.Mapper.BoardListMapper;
import com.techeer.inforplanbackend.domain.list.dto.Request.BoardListRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor //이거 더 생각해보기
public class BoardListService {

    private final BoardListRepository boardListRepository;
    private final BoardListMapper boardListMapper;

    @Transactional
    public BoardList create(BoardListRequestDto boardListRequestDto) {
        return boardListRepository.save(boardListMapper.toEntity(boardListRequestDto));
    }

    public List<BoardList> findAll() {
        return boardListRepository.findAll();
    }


}
