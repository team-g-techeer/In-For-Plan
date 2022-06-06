package com.techeer.inforplanbackend.domain.user.repository;

import com.techeer.inforplanbackend.domain.user.domain.entity.SocialUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SocialUserRepository extends JpaRepository<SocialUsers, Long> {
    Optional<SocialUsers> findByEmail(String email);
}
