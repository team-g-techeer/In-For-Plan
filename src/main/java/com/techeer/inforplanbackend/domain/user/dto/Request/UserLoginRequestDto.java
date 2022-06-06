package com.techeer.inforplanbackend.domain.user.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserLoginRequestDto {

    public String email;

    public String password;

}
