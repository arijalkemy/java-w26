package org.example.starwars;

import org.example.starwars.repository.StarWarsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileReader;

@SpringBootApplication
public class StarwarsApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarwarsApplication.class, args);
    }

}
