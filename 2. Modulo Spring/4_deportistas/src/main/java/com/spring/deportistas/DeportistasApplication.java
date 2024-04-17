package com.spring.deportistas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeportistasApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeportistasApplication.class, args);
        System.out.print("El ejercicio fue pensado bajo la premisa del enunciado sin crear campos ");
        System.out.println("o modificar en las entidades correspondientes.");
    }

}
