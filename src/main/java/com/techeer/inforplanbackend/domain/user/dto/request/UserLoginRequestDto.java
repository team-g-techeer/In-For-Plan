package com.techeer.inforplanbackend.domain.user.dto.request;

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
