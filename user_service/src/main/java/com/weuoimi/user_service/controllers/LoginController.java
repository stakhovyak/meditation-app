package com.weuoimi.user_service.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.weuoimi.user_service.dto.request.LoginRequestDto;
import com.weuoimi.user_service.dto.response.JwtAuthResponse;
import com.weuoimi.user_service.services.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class LoginController {

    private final AuthService authService;

    @Operation(
        summary = "Login a user",
        description = "performs login and returns JWT token",
        responses = {
            @ApiResponse(responseCode = "200",
                         description = "Success",
                         content = @Content(schema = @Schema(implementation = JwtAuthResponse.class)))
        }
    )
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> loginProfile(@RequestBody LoginRequestDto loginRequest) {
        
        try {

            return ResponseEntity.ok(authService.login(loginRequest));
        } catch (BadCredentialsException | IllegalArgumentException e) {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    
}
