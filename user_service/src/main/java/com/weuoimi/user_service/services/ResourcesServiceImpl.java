package com.weuoimi.user_service.services;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.weuoimi.user_service.entity.User;
import com.weuoimi.user_service.repos.UserRepository;
import com.weuoimi.user_service.repos.UserSpecification;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResourcesServiceImpl implements ResourcesService {

    private final UserRepository userRepository;

    @Override
    public Page<User> getProfile(Map<String, Object> params, Pageable pageable) throws IllegalArgumentException {
        
        UserSpecification userSpecification = new UserSpecification(params);

        Specification<User> passwordlessUserSpecification = Specification.where(userSpecification).and(UserSpecification.fitlerOutPasswordParam());

        return userRepository.findAll(passwordlessUserSpecification, pageable);
    }     
}
