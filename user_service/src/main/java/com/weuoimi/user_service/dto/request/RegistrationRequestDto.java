package com.weuoimi.user_service.dto.request;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "registration request dto")
public class RegistrationRequestDto {
    
    @Schema(description = "user's email", required = true)
    private Optional<String> email;

    @Schema(description = "user's password", required = true)
    private Optional<String> password;

    @Schema(description = "user's username", required = true)
    private Optional<String> username;
}
