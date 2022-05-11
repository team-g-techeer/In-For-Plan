package com.techeer.inforplanbackend.domain.user.domain.repository;

import com.techeer.inforplanbackend.domain.user.domain.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
}
