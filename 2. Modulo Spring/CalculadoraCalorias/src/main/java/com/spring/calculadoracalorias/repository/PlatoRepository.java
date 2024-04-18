package com.spring.calculadoracalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.calculadoracalorias.entity.Ingrediente;
import com.spring.calculadoracalorias.entity.Plato;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlatoRepository {

    private static List<Plato> listPlatos = new ArrayList<>();

    static {
        loadDataBase();
    }

    private static void loadDataBase() {
        // Creamos un plato

        for (int i = 0; i < 6; i++) {
            Random random = new Random();
            Plato plato = new Plato();
            plato.setListIngredientes(getRandomIngredientes());
            plato.setName("plato" + i);
            listPlatos.add(plato);
        }

    }

    public static List<Ingrediente> seleccionarIngredientesAleatorios(List<Ingrediente> ingredientes, int cantidad) {
        Random random = new Random();
        List<Ingrediente> ingredientesAleatorios = new ArrayList<>();
        List<Ingrediente> copiaIngredientes = new ArrayList<>(ingredientes);
        for (int i = 0; i < cantidad; i++) {
            int indiceAleatorio = random.nextInt(copiaIngredientes.size());
            ingredientesAleatorios.add(copiaIngredientes.remove(indiceAleatorio));
        }
        return ingredientesAleatorios;
    }

    private static List<Ingrediente> getRandomIngredientes(){
        // Seleccionamos 5 ingredientes aleatorios
        List<Ingrediente> ingredientesAleatorios = seleccionarIngredientesAleatorios(IngredienteRepository.getAllIngredientes(), 5);
        // Agregamos los ingredientes al plato
        return ingredientesAleatorios;
    }

    public static List<Plato> getAllPlatos() {
        return listPlatos;
    }

}
