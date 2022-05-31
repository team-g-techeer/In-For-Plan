package com.techeer.inforplanbackend.domain.user.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
public class UserCreateRequestDto {

    public String email;

    public String password;

    public String name;

    public String phoneNumber;

    public String url;

    public Date birthDate;

}
