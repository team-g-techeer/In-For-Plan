package com.techeer.inforplanbackend.domain.list.domain.repository;

import com.techeer.inforplanbackend.domain.list.domain.entity.BoardList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardListRepository extends JpaRepository<BoardList, Long> {
}
