package com.techeer.inforplanbackend.domain.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLoginResponseDto {

    private String accessToken;

    private String email;

}
