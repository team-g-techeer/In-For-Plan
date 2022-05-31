package com.techeer.inforplanbackend.domain.user.controller;

import com.techeer.inforplanbackend.domain.user.domain.entity.Users;
import com.techeer.inforplanbackend.domain.user.dto.Mapper.UserMapper;
import com.techeer.inforplanbackend.domain.user.dto.Request.JwtRequest;
import com.techeer.inforplanbackend.domain.user.dto.Request.UserCreateRequestDto;
import com.techeer.inforplanbackend.domain.user.dto.Response.JwtResponse;
import com.techeer.inforplanbackend.domain.user.dto.Response.UserResponseDto;
import com.techeer.inforplanbackend.domain.user.service.UserService;
import com.techeer.inforplanbackend.global.config.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/users")
public class UserController {

    public final UserService userService;

    public final UserMapper userMapper;

    private final JwtTokenUtil jwtTokenUtil;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto create(@Validated @RequestBody UserCreateRequestDto userRequestDto){

        Users user = userService.create(userRequestDto);

        return userMapper.fromEntity(user);
    }

    @GetMapping("/{id}")
    public UserResponseDto findById(@PathVariable Long id){

        return userService.findById(id);

    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        final Users user = userService.authenticateByEmailAndPassword
                (authenticationRequest.getEmail(), authenticationRequest.getPassword());
        final String token = jwtTokenUtil.generateToken(user.getEmail());
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
