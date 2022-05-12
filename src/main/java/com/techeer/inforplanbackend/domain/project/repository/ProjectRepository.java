package com.techeer.inforplanbackend.domain.project.repository;

import com.techeer.inforplanbackend.domain.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;


public interface  ProjectRepository extends JpaRepository<Project, Long> { //JpaRepository를 상속시 기본 CRUD 메소드 생성됨

}
