package com.techeer.inforplanbackend.domain.user.service;

import com.techeer.inforplanbackend.domain.user.domain.entity.Users;
import com.techeer.inforplanbackend.domain.user.domain.repository.UserRepository;
import com.techeer.inforplanbackend.domain.user.dto.Mapper.UserMapper;
import com.techeer.inforplanbackend.domain.user.dto.Request.UserRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class UserService {

    public final UserRepository userRepository;

    public final UserMapper userMapper;

    @Transactional
    public Users create(UserRequestDto userRequestDto){

        return userRepository.save(userMapper.toEntity(userRequestDto));

    }
}
