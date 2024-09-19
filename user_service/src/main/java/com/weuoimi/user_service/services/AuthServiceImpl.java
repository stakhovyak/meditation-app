package com.weuoimi.user_service.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.weuoimi.user_service.dto.request.LoginRequestDto;
import com.weuoimi.user_service.dto.request.RegistrationRequestDto;
import com.weuoimi.user_service.dto.response.JwtAuthResponse;
import com.weuoimi.user_service.entity.User;
import com.weuoimi.user_service.repos.UserRepository;
import com.weuoimi.user_service.roles.Role;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    
    @Override
    public JwtAuthResponse login(LoginRequestDto request) {
         authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtService.generateToken(user);
        return JwtAuthResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthResponse register(RegistrationRequestDto request) {

        if (request.getPassword() == null || request.getUsername() == null || request.getEmail() == null) {
            throw new IllegalArgumentException("Missing required fields for registration");
        }

        var user = User.builder().username(request.getUsername())
                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER).build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthResponse.builder().token(jwt).build();
    }
}
 