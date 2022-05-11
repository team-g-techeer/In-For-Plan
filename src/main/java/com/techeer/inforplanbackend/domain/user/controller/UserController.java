package com.techeer.inforplanbackend.domain.user.controller;

import com.techeer.inforplanbackend.domain.user.domain.entity.Users;
import com.techeer.inforplanbackend.domain.user.dto.Mapper.UserMapper;
import com.techeer.inforplanbackend.domain.user.dto.Request.UserRequestDto;
import com.techeer.inforplanbackend.domain.user.dto.Response.UserResponseDto;
import com.techeer.inforplanbackend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/users")
public class UserController {

    public final UserService userService;

    public final UserMapper userMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto create(@Validated @RequestBody UserRequestDto userRequestDto){

        Users user = userService.create(userRequestDto);

        return userMapper.fromEntity(user);
    }
}
