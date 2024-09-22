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

import java.util.Optional;

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

        Optional<String> usersPassword = Optional.ofNullable(request.getPassword()).orElseThrow(() -> new IllegalArgumentException());

        Optional<String> usersEmail = Optional.ofNullable(request.getEmail()).orElseThrow(() -> new  IllegalArgumentException());
        
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usersEmail.get(), usersPassword.get()));

        User user = userRepository.findByEmail(usersEmail.get())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        var jwt = jwtService.generateToken(user);

        return JwtAuthResponse.builder().token(jwt).build();
    }

@Override
    public JwtAuthResponse register(RegistrationRequestDto request) {

        Optional<String> usersUsername = Optional.ofNullable(request.getUsername()).orElseThrow(() -> new IllegalArgumentException());

        Optional<String> usersPassword = Optional.ofNullable(request.getPassword()).orElseThrow(() -> new IllegalArgumentException());

        Optional<String> usersEmail = Optional.ofNullable(request.getEmail()).orElseThrow(() -> new IllegalArgumentException());

        var user = User.builder().username(usersUsername.get())
                .email(usersEmail.get()).password(passwordEncoder.encode(usersPassword.get()))
                .role(Role.USER).build();

        userRepository.save(user);

        var jwt = jwtService.generateToken(user);

        return JwtAuthResponse.builder().token(jwt).build();
    }
}
 