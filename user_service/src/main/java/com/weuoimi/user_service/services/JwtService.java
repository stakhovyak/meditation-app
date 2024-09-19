package com.weuoimi.user_service.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    String extractUserName(String token);

    String generateToken(UserDetails userDetails);

    // TODO: add custom validation later
    boolean isTokenValid(String token, UserDetails userDetails);
}
