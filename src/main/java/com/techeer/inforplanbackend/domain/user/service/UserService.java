package com.techeer.inforplanbackend.domain.user.service;

import com.techeer.inforplanbackend.domain.user.domain.entity.Users;
import com.techeer.inforplanbackend.domain.user.domain.repository.UserRepository;
import com.techeer.inforplanbackend.domain.user.dto.Mapper.UserMapper;
import com.techeer.inforplanbackend.domain.user.dto.Request.UserRequestDto;
import com.techeer.inforplanbackend.domain.user.dto.Response.UserResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
//@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;

    public final UserMapper userMapper;

    @Transactional
    public Users create(UserRequestDto userRequestDto){

        return userRepository.save(userMapper.toEntity(userRequestDto));

    }

    @Transactional
    public UserResponseDto findById (Long id){
        Users user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));
        return userMapper.fromEntity(user);
    }
}
