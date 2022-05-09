package com.techeer.inforplanbackend.domain.project.domain.repository;

import com.techeer.inforplanbackend.domain.project.domain.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {


}
