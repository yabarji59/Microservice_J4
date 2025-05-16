package com.example.student.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI studentOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestion des Étudiants")
                        .description("API REST pour la gestion des étudiants")
                        .version("1.0")
                        .contact(new Contact()
                                .name("École IT")
                                .email("contact@ecole-it.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html")));
    }
} 