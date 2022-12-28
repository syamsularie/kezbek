package com.kezbek.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;

@SpringBootApplication(
        exclude = {FlywayAutoConfiguration.class}
)
public class KezbekApplication {
    public static void main(String[] args) {
        SpringApplication.run(KezbekApplication.class, args);
    }

}
