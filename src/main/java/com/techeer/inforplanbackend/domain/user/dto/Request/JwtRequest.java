package com.techeer.inforplanbackend.domain.user.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtRequest {

    private String email;

    private String password;

}
