package com.techeer.inforplanbackend.domain.user.repository;

import com.techeer.inforplanbackend.domain.user.domain.entity.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<User> findByEmail(String email);
}
