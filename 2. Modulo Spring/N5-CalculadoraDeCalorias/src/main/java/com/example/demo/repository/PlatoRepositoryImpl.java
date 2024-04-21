package com.example.demo.repository;

import com.example.demo.entity.Ingrediente;
import com.example.demo.entity.Plato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PlatoRepositoryImpl implements IPlatoRepository {

    private List<Ingrediente> ingredientes;
    private List<Plato> platos;

    @PostConstruct
    public void postConstruct() {
        this.ingredientes = cargarIngredientes();
        this.platos = cargarPlatos();
    }

    private List<Ingrediente> cargarIngredientes() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("data/food.json");
            return objectMapper.readValue(inputStream, new TypeReference<List<Ingrediente>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            // TODO agregar excepcion
            return null;
        }
    }

    private List<Plato> cargarPlatos() {
        platos = new ArrayList<>();

        // La totalidad del plato (100%) es la suma de los procentajes de cada uno de sus ingredientes
        // Creo plato 1
        Map<Ingrediente, Integer> ingredientesPlato1 = new HashMap<>();
        ingredientesPlato1.put(ingredientes.get(0), 10);
        ingredientesPlato1.put(ingredientes.get(1), 90);

        Plato plato1 = new Plato("Plato 1", ingredientesPlato1);
        platos.add(plato1);

        // Creo plato 2
        Map<Ingrediente, Integer> ingredientesPlato2 = new HashMap<>();
        ingredientesPlato2.put(ingredientes.get(2), 60);
        ingredientesPlato2.put(ingredientes.get(3), 40);

        Plato plato2 = new Plato("Plato 2", ingredientesPlato2);
        platos.add(plato2);


        return platos;
    }

    @Override
    public List<Ingrediente> obtenerIngredientes() {
        return ingredientes;
    }

    @Override
    public List<Plato> obtenerPlatos() {
        return platos;
    }
}
