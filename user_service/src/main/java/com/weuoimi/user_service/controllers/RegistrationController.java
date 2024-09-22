package com.weuoimi.user_service.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weuoimi.user_service.dto.request.RegistrationRequestDto;
import com.weuoimi.user_service.dto.response.JwtAuthResponse;
import com.weuoimi.user_service.services.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class RegistrationController {

    private final AuthService authService;

    @Operation(
        summary = "Register a new user",
        description = "This endpoint allows a user to register with email, password, and name.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful registration",
                         content = @Content(schema = @Schema(implementation = JwtAuthResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
        }
    )
    @PostMapping("/register")
    public ResponseEntity<JwtAuthResponse> registerProfile(@RequestBody RegistrationRequestDto registrationRequest) {
        
        log.info("Received registration request: {}", registrationRequest);
        
        try {
            
            return ResponseEntity.ok(authService.register(registrationRequest));
        } catch (BadCredentialsException | IllegalArgumentException e) {
            
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
