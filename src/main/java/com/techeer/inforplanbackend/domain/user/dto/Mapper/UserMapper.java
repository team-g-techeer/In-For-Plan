package com.techeer.inforplanbackend.domain.user.dto.Mapper;


import com.techeer.inforplanbackend.domain.user.domain.entity.Users;
import com.techeer.inforplanbackend.domain.user.dto.Request.UserCreateRequestDto;
import com.techeer.inforplanbackend.domain.user.dto.Response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    public Users toEntity(UserCreateRequestDto userRequestDto){
        return Users.builder()
                .email(userRequestDto.email)
                .name(userRequestDto.name)
                .password(userRequestDto.password)
                .birthDate(userRequestDto.birthDate)
                .url(userRequestDto.url)
                .phoneNumber(userRequestDto.phoneNumber)
                .build();
    }

    public UserResponseDto fromEntity(Users users){
        return UserResponseDto.builder()
                .id(users.getId())
                .email(users.getEmail())
                .name(users.getName())
                .url(users.getUrl())
                .password(users.getPassword())
                .phoneNumber(users.getPhoneNumber())
                .birthDate(users.getBirthDate())
                .build();
    }

}
