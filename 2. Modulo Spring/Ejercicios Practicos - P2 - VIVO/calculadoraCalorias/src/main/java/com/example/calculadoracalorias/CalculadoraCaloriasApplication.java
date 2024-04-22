package com.example.calculadoracalorias;

import com.example.calculadoracalorias.entity.Ingrediente;
import com.example.calculadoracalorias.repository.IngredientesRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class CalculadoraCaloriasApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculadoraCaloriasApplication.class, args);

    }
}
