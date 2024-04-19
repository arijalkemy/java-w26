package com.example.calorias.repositorios;

import com.example.calorias.modelo.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class IngredienteRepositorio {
    List<Ingrediente> ingredientes;

    public IngredienteRepositorio() throws IOException {
        String fileName = getFileNameToLoadJsonFile();
        ingredientes = deserializeJson(fileName);
    }

    public Ingrediente getIngredientePorNombre(String nombre){

        return ingredientes
                .stream().filter(
                        i -> i.getName().equals(nombre)
                )
                .findFirst()
                .orElse(ingredientes.get(0));
    }



    private static String getFileNameToLoadJsonFile() throws IOException {
        String fileName = "food.json";
        ClassPathResource resource = new ClassPathResource(fileName);
        InputStream inputStream = resource.getInputStream();

        try {
            byte[] jsonBytes = FileCopyUtils.copyToByteArray(inputStream);
            return new String(jsonBytes, StandardCharsets.UTF_8);
        } finally {
            inputStream.close();
        }
    }
    private static List<Ingrediente> deserializeJson(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, new TypeReference<List<Ingrediente>>() {});
    }


}

