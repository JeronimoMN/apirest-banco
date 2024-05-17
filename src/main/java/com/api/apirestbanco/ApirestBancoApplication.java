package com.api.apirestbanco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ApirestBancoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApirestBancoApplication.class, args);
    }

}
