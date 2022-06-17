package com.techeer.inforplanbackend.domain.members_project.service;

import com.techeer.inforplanbackend.domain.members_project.dto.Mapper.Members_ProjectMapper;
import com.techeer.inforplanbackend.domain.members_project.repository.Members_ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class Members_ProjectService {

    private Members_ProjectRepository MP_repository;
    private Members_ProjectMapper mapper;

}
