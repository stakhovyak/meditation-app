package com.weuoimi.user_service.repos;

import java.util.Optional;

import com.weuoimi.user_service.entity.User;

public interface UserPostgreRepository {
    Optional<User> findByEmail(String email);
}
