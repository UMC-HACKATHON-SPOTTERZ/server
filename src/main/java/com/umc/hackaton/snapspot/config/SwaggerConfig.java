package com.umc.hackaton.snapspot.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "UMC Hackaton Snap Shot",
                description = "UMC Hackaton Snap Shot API 명세서",
                version = "1.0.0"))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi UMCStudyAPI() {
        String[] paths = {"/**"};

        return GroupedOpenApi.builder()
                .group("API v1")
                .pathsToMatch(paths)
                .build();
    }
}
