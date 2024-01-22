package com.example.PasswordSaver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.PasswordSaver")
public class PasswordSaverApplication {

    public static void main(String[] args) {
        SpringApplication.run(PasswordSaverApplication.class, args);
    }
}
