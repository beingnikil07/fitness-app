package com.project.fitness.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Fitness Tracker API")
                        .description("Rest APIs for fitness tracker application")
                        .version("1.0")
                        .contact(
                                new Contact()
                                        .name("Nikhil Kumar Rana")
                                        .email("kumarnikil220@gmail.com")
                        )
                );
    }

}
