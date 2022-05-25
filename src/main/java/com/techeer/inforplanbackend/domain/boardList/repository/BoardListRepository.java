package com.techeer.inforplanbackend.domain.boardList.repository;

import com.techeer.inforplanbackend.domain.boardList.entity.BoardList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardListRepository extends JpaRepository<BoardList, Long> {
}
