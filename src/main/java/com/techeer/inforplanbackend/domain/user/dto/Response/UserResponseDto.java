package com.techeer.inforplanbackend.domain.user.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
public class UserResponseDto {

    private Long id;

    private String email;

    private String password;

    private String name;

    private String phoneNumber;

    private String url;

    private Date birthDate;

}
