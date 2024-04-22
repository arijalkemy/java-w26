package com.example.multicapatemplate.repository.impl;

import com.example.multicapatemplate.model.Ingrediente;
import com.example.multicapatemplate.repository.IRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Repository
@Getter
public class IngredientesRepositoryImpl implements IRepository {
    List<Ingrediente> listOfIngredients;

    public IngredientesRepositoryImpl() throws IOException {
        this.listOfIngredients = new ArrayList<>();
        loadDataBase();
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Ingrediente> ingredientes ;

        file= ResourceUtils.getFile("classpath:food.json");
        ingredientes = objectMapper.readValue(file,new TypeReference<List<Ingrediente>>(){});

        this.listOfIngredients = ingredientes;
    }
}
