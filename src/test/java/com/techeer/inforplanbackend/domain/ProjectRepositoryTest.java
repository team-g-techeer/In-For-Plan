package com.techeer.inforplanbackend.domain;

import com.techeer.inforplanbackend.domain.project.entity.Project;
import com.techeer.inforplanbackend.domain.project.repository.ProjectRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectRepositoryTest {
    @Autowired
    ProjectRepository projectRepository;

    @After
    public void cleanup()
    {
        projectRepository.deleteAll();
    }

    @Test
    public void repository_test(){
        projectRepository.save(Project.builder()
                .project_title("test")
                .url("test1")
                .build());


        List<Project> projectList = projectRepository.findAll();
        Project project = projectList.get(0);

    }

}
