package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.entity.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.util.IOTools;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public abstract class IngredientesRepository {
    public static List<Ingrediente> obtenerArchivo()throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ClassLoader classLoader = IngredientesRepository.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("data/ListaIngredientes.json");
            return objectMapper.readValue(inputStream, new TypeReference<List<Ingrediente>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            // TODO ver que excepcion poner
            return null;
        }
    }
}



