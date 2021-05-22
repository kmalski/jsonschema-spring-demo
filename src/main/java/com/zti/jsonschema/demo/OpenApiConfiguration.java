package com.zti.jsonschema.demo;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI jsonSchemaDemoOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Json Schema with Spring demo API")
                        .description("Demo project for Spring Boot with Json Schema")
                        .version("v1.0.0"));
    }

}
