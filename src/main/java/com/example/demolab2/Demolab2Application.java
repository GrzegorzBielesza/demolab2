package com.example.demolab2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Demolab2Application {

    public static void main(String[] args) {
        SpringApplication.run(Demolab2Application.class, args);
    }

}
