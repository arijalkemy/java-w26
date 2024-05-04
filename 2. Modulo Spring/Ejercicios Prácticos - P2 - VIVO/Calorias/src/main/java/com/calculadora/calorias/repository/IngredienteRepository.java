package com.calculadora.calorias.repository;

import com.calculadora.calorias.entity.Ingrediente;
import com.calculadora.calorias.entity.Platillo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class IngredienteRepository implements IIngredienteRepository{
    List<Ingrediente> ingredientes = new ArrayList();
    List<Platillo> platillos = new ArrayList();

    public IngredienteRepository(){
        getIngredientes();
        getPlatillos();
    }

    @Override
    public void getIngredientes() {
        String jsonFilePath = "src/main/resources/food.json";

        ObjectMapper mapper = new ObjectMapper();

        try {
            String json = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
            ingredientes = mapper.readValue(json, new TypeReference<List<Ingrediente>>(){});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getPlatillos() {

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            List<Ingrediente> ingredientPlato = new ArrayList();
            for (int j = 0; j < 5; j++){
                int index = random.nextInt(ingredientes.size());
                ingredientPlato.add(ingredientes.get(index));
            }
            int weight = random.nextInt(1000);
            int totalCalories = ingredientPlato.stream().mapToInt(Ingrediente::getCalories).sum();
            Ingrediente ingredienteMasCalorico = ingredientPlato.stream().max((a, b) -> a.getCalories() - b.getCalories()).get();
            Platillo platillo = new Platillo("Platillo " + i, weight, ingredientPlato, totalCalories,ingredienteMasCalorico);
            platillos.add(platillo);
        }

    }

    @Override
    public List<Ingrediente> getTodos() {
        return ingredientes;
    }

    @Override
    public List<Platillo> getTodosPlatillo() {
        return platillos;
    }
}
