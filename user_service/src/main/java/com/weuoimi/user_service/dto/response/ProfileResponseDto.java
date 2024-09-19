package com.weuoimi.user_service.dto.response;

import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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
@JsonInclude(JsonInclude.Include.ALWAYS)
@Schema(description = "profile response model")
public class ProfileResponseDto {
    
    @Schema(description = "user's id")
    @JsonProperty("user_id")
    private UUID userId;
    
    @Schema(description = "user's email")
    private String email;
    
    @Schema(description = "user's username")
    private String username;
    
    @Schema(description = "user's properties", required = true, example = "{\"meditation_style\":\"guided\"}")
    private Map<String, String> preferences;
}


