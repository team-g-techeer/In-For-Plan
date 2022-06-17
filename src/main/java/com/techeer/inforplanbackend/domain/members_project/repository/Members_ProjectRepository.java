package com.techeer.inforplanbackend.domain.members_project.repository;

import com.techeer.inforplanbackend.domain.members_project.entity.Members_Project;
import com.techeer.inforplanbackend.domain.project.entity.Project;
import com.techeer.inforplanbackend.domain.user.domain.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Members_ProjectRepository extends JpaRepository <Members_Project,Long> {
    Members_Project findMembers_ProjectByProject(Project project);
    List<Members_Project> findMembers_ProjectByUsers(Users user);
}
