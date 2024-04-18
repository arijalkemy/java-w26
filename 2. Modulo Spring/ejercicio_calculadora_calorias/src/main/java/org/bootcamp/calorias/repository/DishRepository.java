package org.bootcamp.calorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bootcamp.calorias.model.Dish;
import org.bootcamp.calorias.model.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DishRepository {

    private List<Dish> dishList;

    public DishRepository() {
        dishList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Se carga el archivo con la lista de los personajes
            File file = ResourceUtils.getFile("classpath:dishs.json");
            InputStream inputStream = new FileInputStream(file);

            // Se instancia el tipo de referencia
            TypeReference<List<Dish>> typeReference = new TypeReference<List<Dish>>() {
            };

            // Se realiza el mapeo del json a la lista
            dishList = objectMapper.readValue(inputStream, typeReference);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Dish findByName(String name) {
        return dishList.stream()
                .filter(dish -> dish.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(new Dish());
    }

    public List<Dish> findAll(){
        return dishList;
    }

    public Dish save(Dish dish){
        dishList.add(dish);
        return dish;
    }

    public List<Dish> saveAll (List<Dish> dishes){
        dishList.addAll(dishes);
        return dishes;
    }
}
