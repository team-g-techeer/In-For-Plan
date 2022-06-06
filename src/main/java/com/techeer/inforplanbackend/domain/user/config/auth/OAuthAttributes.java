package com.techeer.inforplanbackend.domain.user.config.auth;

import com.techeer.inforplanbackend.domain.user.domain.entity.Role;
import com.techeer.inforplanbackend.domain.user.domain.entity.SocialUsers;
import com.techeer.inforplanbackend.domain.user.domain.entity.Users;
import lombok.Builder;
import lombok.Getter;

import java.text.ParseException;
import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String url;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String url) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.url = url;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .url((String) attributes.get("url"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .url((String) attributes.get("url"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }


    public SocialUsers toEntity() throws ParseException {
        return SocialUsers.builder()
                .name(name)
                .email(email)
                .url(url)
                .user_role(Role.USER)
                .build();
    }
}
