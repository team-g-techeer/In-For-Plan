package com.techeer.inforplanbackend.domain.project.repository;

import com.techeer.inforplanbackend.domain.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    public Optional<Project> findById(Long p_id);

    public List<Project> findAll();

    public void deleteById(Long p_id);

    public Project save(Project project);
}
