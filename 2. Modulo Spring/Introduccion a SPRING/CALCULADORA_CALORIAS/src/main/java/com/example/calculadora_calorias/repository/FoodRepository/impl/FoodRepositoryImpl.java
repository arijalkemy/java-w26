package com.example.calculadora_calorias.repository.FoodRepository.impl;

import com.example.calculadora_calorias.entity.Ingrediente;
import com.example.calculadora_calorias.repository.FoodRepository.IFoodRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class FoodRepositoryImpl implements IFoodRepository {

    private List<Ingrediente> ingredientes;

    public FoodRepositoryImpl() throws IOException {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new ClassPathResource("data/food.json").getFile();
            ingredientes = objectMapper.readValue(file, new TypeReference<>() {});
        } catch (IOException e){
            throw new IOException(e);
        }
    }

    @Override
    public Optional<Ingrediente> findByName(String name) {
        return ingredientes.stream().filter(d -> d.getName().equalsIgnoreCase(name)).findFirst();
    }
}
