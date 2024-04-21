package com.example.ejercicio_arquitectura_multicapa_p2_vivo_calculadora_de_calorias.repository.implementation;

import com.example.ejercicio_arquitectura_multicapa_p2_vivo_calculadora_de_calorias.entity.Ingrediente;
import com.example.ejercicio_arquitectura_multicapa_p2_vivo_calculadora_de_calorias.entity.Plato;
import com.example.ejercicio_arquitectura_multicapa_p2_vivo_calculadora_de_calorias.repository.IIngredienteRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@Repository
public class IngredienteRepositoryImpl implements IIngredienteRepository {
    private List<Ingrediente> ingredientes;

    public IngredienteRepositoryImpl() {
        this.ingredientes = this.cargarBaseDeDatos();
    }

    private List<Ingrediente> cargarBaseDeDatos() {
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
    public Integer findCaloriasDeIngrediente(String nombre) {
        Integer calorias = 0;
        for(Ingrediente ingrediente : ingredientes) {
            if(ingrediente.getName().equalsIgnoreCase(nombre)) {
                return ingrediente.getCalories();
            }
        }
        return calorias;
    }

    @Override
    public Ingrediente findIngredienteByName(String nombre) {
        return ingredientes.stream()
            .filter(ingrediente -> ingrediente.getName().equals(nombre)).findFirst().get();
    }

    @Override
    public Ingrediente findIngredienteMasCalorias() {
        return ingredientes.stream()
            .max(Comparator.comparing(Ingrediente::getCalories)).get();
    }
}
