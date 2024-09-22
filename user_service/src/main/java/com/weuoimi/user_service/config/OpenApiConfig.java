package com.weuoimi.user_service.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class OpenApiConfig {

    @Value("${application.description}")
    private String appDescription;

    @Value("${application.version}")
    private String appVersion;

    @Bean
    public GroupedOpenApi publicProfilesApi() {
        return GroupedOpenApi.builder()
                .group("Profiles")
                .pathsToMatch("/api/v1/profiles/**")
                .build();
    }

    @Bean
    public GroupedOpenApi publicAuthApi() {
        return GroupedOpenApi.builder()
                .group("Authentification")
                .pathsToMatch("/api/v1/auth/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info().title("Application API")
                .version(appVersion)
                .description(appDescription)
                .license(new License().name("Apache 2.0") // TODO: think about the license
                        .url("http://springdoc.org"))
                .contact(new Contact().name("weuoimi")
                        .email("weuoimi@gmail.com")))
                .servers(List.of(new Server().url("http://localhost:8080")
                        .description("Dev service"),
                        new Server().url("http://localhost:8082")
                                .description("Beta service")))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components().addSecuritySchemes("bearerAuth",
                        new SecurityScheme()
                                .name("bearerAuth")
                                .type(SecurityScheme.Type.HTTP)
                                .bearerFormat("JWT")
                                .in(SecurityScheme.In.HEADER)
                                .scheme("bearer")));
    }
}
