package com.bootcamp.c3calculadoracalorias.repository;

import com.bootcamp.c3calculadoracalorias.model.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class IngredienteRepositoryImpl implements IngredienteRepository {
    List<Ingrediente> ingredientes;
    public IngredienteRepositoryImpl() {
        ingredientes = obtenerIngredientes();
    }

    public List<Ingrediente> obtenerIngredientes() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {};
        List<Ingrediente> ingredientes = null;
        try {
            ingredientes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientes;
    }

    @Override
    public Ingrediente encontrarIngrediente(String nombre){
        List<Ingrediente> ingredientes = obtenerIngredientes();
        
       return ingredientes.stream().filter(ingrediente -> ingrediente.getNombre().equals(nombre)).findFirst().orElse(null);
    }
    // Otros métodos de la clase StarWarsRepository...
}
