package com.weuoimi.user_service.services;
import java.util.Map;
import com.weuoimi.user_service.entity.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ResourcesService {

    Page<User> getProfile(Map<String, Object> params, Pageable pageable) throws IllegalArgumentException;
}
