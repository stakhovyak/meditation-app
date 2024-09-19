package com.weuoimi.user_service.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// @JsonIgnoreProperties(ignoreUnknown = true)
// @JsonInclude(JsonInclude.Include.ALWAYS)
@Schema(description = "registration request dto")
public class RegistrationRequestDto {
    
    // @NonNull
    @Schema(description = "user's email", required = true)
    private String email;

    // @NonNull
    @Schema(description = "user's password", required = true)
    private String password;

    // @NonNull
    @Schema(description = "user's username", required = true)
    private String username;
}
