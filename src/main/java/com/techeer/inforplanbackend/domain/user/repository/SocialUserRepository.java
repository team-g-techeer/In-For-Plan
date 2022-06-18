package com.techeer.inforplanbackend.domain.user.repository;

import com.techeer.inforplanbackend.domain.user.domain.entity.SocialUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SocialUserRepository extends JpaRepository<SocialUser, Long> {
    Optional<SocialUser> findByEmail(String email);
    //소셜 로그인으로 반환되는 값 중에서 email을 통해 이미 생성된 사용자인지
    //처음 가입하는 사용자인지 판단한다.
}
