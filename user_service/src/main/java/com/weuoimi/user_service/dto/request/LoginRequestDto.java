package com.weuoimi.user_service.dto.request;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "login request model, should have a bearer auth token in header!")
public class LoginRequestDto {

    @Schema(description = "user's email")
    private Optional<String> email;

    @Schema(description = "user's password")
    private Optional<String> password;
}
