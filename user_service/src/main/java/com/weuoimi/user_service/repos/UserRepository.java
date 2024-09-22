package com.weuoimi.user_service.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.weuoimi.user_service.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>, UserPostgreRepository, JpaSpecificationExecutor<User> {

}
