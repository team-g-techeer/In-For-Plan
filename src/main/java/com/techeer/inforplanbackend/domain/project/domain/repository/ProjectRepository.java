package com.techeer.inforplanbackend.domain.project.domain.repository;

import com.techeer.inforplanbackend.domain.project.domain.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;


public interface  ProjectRepository extends JpaRepository<Project, Long> { //JpaRepository를 상속시 기본 CRUD 메소드 생성됨

}
