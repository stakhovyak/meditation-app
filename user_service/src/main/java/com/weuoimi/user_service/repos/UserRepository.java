package com.weuoimi.user_service.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weuoimi.user_service.entity.User;

// TODO: implement user domain class and repo interfaces for postgre
public interface UserRepository extends JpaRepository<User, Integer>, UserPostgreRepository {

}
