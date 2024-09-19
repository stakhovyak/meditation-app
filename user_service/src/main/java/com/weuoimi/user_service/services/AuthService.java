package com.weuoimi.user_service.services;

import com.weuoimi.user_service.dto.request.LoginRequestDto;
import com.weuoimi.user_service.dto.request.RegistrationRequestDto;
import com.weuoimi.user_service.dto.response.JwtAuthResponse;

public interface AuthService {

    JwtAuthResponse login(LoginRequestDto request);

    JwtAuthResponse register(RegistrationRequestDto request);
}
