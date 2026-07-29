package com.example.bus_reservation_system.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Bus Reservation System")
                        .version("1.0.0")
                        .description("REST API documentation for managing buses and passenger bookings"));
    }

}
