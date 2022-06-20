package com.techeer.inforplanbackend.domain.boardList.service;

import com.techeer.inforplanbackend.domain.boardList.dto.mapper.BoardListMapper;
import com.techeer.inforplanbackend.domain.boardList.dto.request.BoardListRequestDto;
import com.techeer.inforplanbackend.domain.boardList.dto.response.BoardListResponseDto;
import com.techeer.inforplanbackend.domain.boardList.entity.BoardList;
import com.techeer.inforplanbackend.domain.boardList.repository.BoardListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardListService {

    private final BoardListRepository boardListRepository;
    public final BoardListMapper boardListMapper;

    @Transactional
    public BoardList save(BoardListRequestDto dto){

        return boardListRepository.save(boardListMapper.toEntity(dto));
    }

    @Transactional
    public List<BoardList> findAll(){
        return boardListRepository.findAll();
    }

    @Transactional
    public Optional<BoardList> findById(Long id){
        try{
            Optional<BoardList> result = boardListRepository.findById(id);
            if(result.isPresent())
            {
                return result;
            } else
            {
                return Optional.ofNullable(result.orElse(null));
            }
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Request");
        }
    }

    @Transactional
    public void deleteBoardList(Long id){
        boardListRepository.deleteById(id);
    }

    @Transactional
    public Long updateBoardList(Long id, BoardListResponseDto dto){
        BoardList boardList = boardListRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 리스트가 없습니다."));

        boardList.update(dto.getBoardList_title());

        return id;
    }


}
