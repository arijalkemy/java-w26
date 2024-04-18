package com.EjercicioSpring.Ejercicio9_CalculadoraCalorias.repository;

import com.EjercicioSpring.Ejercicio9_CalculadoraCalorias.entity.Ingrediente;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class IngredienteRepository {

    public List<Ingrediente> getAll() {
        List<Ingrediente> ingredientes = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File archivo = new File("src/main/resources/static/1. c. food.json");
            JsonNode jsonNode = objectMapper.readTree(archivo);
            for (JsonNode node : jsonNode) {
                ingredientes.add(new Ingrediente(node.get("name").asText(), node.get("calories").asInt()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ingredientes;
    }
}
