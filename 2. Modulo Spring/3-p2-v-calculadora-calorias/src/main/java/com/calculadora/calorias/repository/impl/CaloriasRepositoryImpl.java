package com.calculadora.calorias.repository.impl;

import com.calculadora.calorias.dto.IngredienteDTO;
import com.calculadora.calorias.repository.CaloriasRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class CaloriasRepositoryImpl implements CaloriasRepository {

    private final List<IngredienteDTO> ingredientes;

    public CaloriasRepositoryImpl() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new ClassPathResource("data/food.json").getFile();
            ingredientes = objectMapper.readValue(file, new TypeReference<List<IngredienteDTO>>() {});
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    @Override
    public IngredienteDTO findIngredienteByNombre(String nombreIngrediente) {
        Optional<IngredienteDTO> first = ingredientes.stream().filter(ingredientDTO -> ingredientDTO.getNombre().equals(nombreIngrediente)).findFirst();
        IngredienteDTO result = null;
        if (first.isPresent())
            result = first.get();
        return result;
    }
}
