package com.techeer.inforplanbackend.domain.user.domain.repository;

import com.techeer.inforplanbackend.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    //Optional User<>
    
}
