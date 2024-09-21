package com.weuoimi.user_service.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
