package com.techeer.inforplanbackend.domain.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtRequest {

    private String email;

    private String password;

}
