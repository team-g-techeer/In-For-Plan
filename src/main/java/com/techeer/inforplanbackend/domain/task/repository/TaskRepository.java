package com.techeer.inforplanbackend.domain.task.repository;

import com.techeer.inforplanbackend.domain.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    /*
        JpaRepository를 단순하게 상속하는 것만으로도 Entity 하나에 대해서 다음과 같은
        기능을 제공하게 된다.

        save() : 레코드 저장(insert, update)
        fineOne() : primary Key로 레코드 한 건 찾기
        findAll() : 전체 레코드 불러오기, 정렬(sort), 페이징(pageable) 가능
        count() : 레코드 개수
        delete() : 레코드 삭제
     */

//    public Task update(Long task_id, TaskRequestDto taskRequestDto);
}
