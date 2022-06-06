package com.techeer.inforplanbackend.domain.user.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLoginResponseDto {

    private String accessToken;

    private String email;

}
