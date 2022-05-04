package com.techeer.inforplanbackend.domain.user.domain.repository;

import org.springframework.stereotype.Repository;
import com.techeer.inforplanbackend.domain.user.domain.entity.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(User user) {
        em.persist(user);
        return user.getId();
    }

    public User find(String email){
        return em.find(User.class, email);
    }
    
}
