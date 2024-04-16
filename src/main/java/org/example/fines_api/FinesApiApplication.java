package org.example.fines_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FinesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinesApiApplication.class, args);
    }

}
