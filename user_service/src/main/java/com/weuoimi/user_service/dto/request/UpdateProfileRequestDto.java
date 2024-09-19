package com.weuoimi.user_service.dto.request;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "update profile model")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateProfileRequestDto {
    
    @Schema(description = "user's username", required = true)
    private String username;
    
    @Schema(description = "user's email", required = true)
    private String email;
    
    @Schema(description = "user's parameters", required = true, example = "{\"meditation-style\":\"guided\"}")
    private Map<String, String> preferences;
}
