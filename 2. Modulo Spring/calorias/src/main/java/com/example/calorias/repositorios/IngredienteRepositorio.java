package com.example.calorias.repositorios;

import com.example.calorias.modelo.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class IngredienteRepositorio {
    List<Ingrediente> ingredientes;

    public IngredienteRepositorio(ResourceLoader resourceLoader) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = resourceLoader.getResource("classpath:food.json");
        ingredientes = objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {});
    }

    public Ingrediente getIngredientePorNombre(String nombre){

        return ingredientes
                .stream().filter(
                        i -> i.getName().equals(nombre)
                )
                .findFirst()
                .orElse(ingredientes.get(0));
    }

}

