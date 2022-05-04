package com.techeer.inforplanbackend.domain.user.domain.repository;

import org.springframework.stereotype.Repository;
import com.techeer.inforplanbackend.domain.user.domain.entity.Users;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Users user) {
        em.persist(user);
        return user.getId();
    }

    public Users find(String email){
        return em.find(Users.class, email);
    }
    
}
