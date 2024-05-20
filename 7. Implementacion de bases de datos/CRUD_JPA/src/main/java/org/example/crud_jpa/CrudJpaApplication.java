package org.example.crud_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class CrudJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudJpaApplication.class, args);
    }

}
