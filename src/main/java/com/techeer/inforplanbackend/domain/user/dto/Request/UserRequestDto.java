package com.techeer.inforplanbackend.domain.user.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.sql.Date;

@Builder
@AllArgsConstructor
public class UserRequestDto {

    public String email;

    public String password;

    public String name;

    public String phoneNumber;

    public String url;

    public Date birthDate;

}
