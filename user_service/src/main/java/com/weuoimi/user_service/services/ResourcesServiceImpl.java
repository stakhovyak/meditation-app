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
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ResourcesServiceImpl implements ResourcesService {

    private final UserRepository userRepository;

    @Override
    public Page<User> getProfile(Map<String, Object> params, Pageable pageable) throws IllegalArgumentException {

        Specification<User> passwordlessUserSpecification = new UserSpecification(params);
        log.info("created user specification for params: {}", params.toString());

        /* Specification<User> passwordlessUserSpecification = Specification.where(userSpecification)
                .and(UserSpecification.fitlerOutPasswordParam()); */

        log.info("UserSpecification after password filter: {}", passwordlessUserSpecification.toString());

        log.info("filtered out password parameter for security reasons");

        return userRepository.findAll(passwordlessUserSpecification, pageable);
    }
}
