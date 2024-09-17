package com.weuoimi.user_service.config;

import java.util.List;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

import org.springframework.beans.factory.annotation.Value;

@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi publicUserApi() {
        return GroupedOpenApi.builder()
                                .group("Users")
                                .pathsToMatch("users/**")
                                .build();
    }

    @Bean
    public OpenAPI customOpenAPI(@Value("${application.description}") String appDescription,
                                 @Value("${application.version}") String appVersion) {
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
                                                     .description("Beta service")));
                                }
}
