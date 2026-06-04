package com.wipro.gateway.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.*;


@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                .title("Healthcare API Gateway")
                .version("1.0")
                .description("Gateway for Patient & Appointment Services"));
    }
}