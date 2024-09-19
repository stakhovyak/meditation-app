package com.weuoimi.user_service.repos;

import java.util.Optional;

import com.weuoimi.user_service.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class UserPostgreRepositoryImpl implements UserPostgreRepository {

    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<User> findByEmail(String email) {
        String query = "SELECT u FROM User u WHERE u.email = :email";
        User user = entityManager.createQuery(query, User.class)
                                 .setParameter("email", email)
                                 .getSingleResult();
        return Optional.ofNullable(user);
    }
}
