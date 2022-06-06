package com.techeer.inforplanbackend.domain.user.config.auth;

import com.techeer.inforplanbackend.domain.user.domain.entity.SocialUsers;
import lombok.Getter;
import java.io.Serializable;

@Getter
public class SessionUsers implements Serializable {

    private String name;
    private String email;
    private String picture;

    public SessionUsers(SocialUsers users){
        this.name = users.getName();
        this.email = users.getEmail();
        this.picture = users.getUrl();
    }
}