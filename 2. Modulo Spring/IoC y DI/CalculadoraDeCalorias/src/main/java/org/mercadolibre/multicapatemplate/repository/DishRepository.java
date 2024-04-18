package org.mercadolibre.multicapatemplate.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mercadolibre.multicapatemplate.entity.Dish;
import org.mercadolibre.multicapatemplate.entity.Ingredient;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Repository
public class DishRepository {

    List<Dish> dishList;
    List<Ingredient> ingredientList;

    public DishRepository(ResourceLoader resourceLoader) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = resourceLoader.getResource("classpath:static/ingredients.json");
        this.ingredientList = objectMapper.readValue(
                resource.getInputStream(),
                new TypeReference<List<Ingredient>>() {
                });

        Random random = new Random();
        this.dishList = List.of(
                new Dish("Pollo con papas", List.of(
                    this.ingredientList.get(random.nextInt(100)),
                    this.ingredientList.get(random.nextInt(100)),
                    this.ingredientList.get(random.nextInt(100))
                )),
                new Dish("Bondiola braseada", List.of(
                    this.ingredientList.get(random.nextInt(100)),
                    this.ingredientList.get(random.nextInt(100))
                )),
                new Dish("Carne asada", List.of(
                        this.ingredientList.get(random.nextInt(100))
                )),
                new Dish("Fideos con crema", List.of(
                        this.ingredientList.get(random.nextInt(100)),
                        this.ingredientList.get(random.nextInt(100))
                ))
        );
    }

    public Dish getFoodPlateWith(String dishName) {
        Optional<Dish> dish = this.dishList
                .stream()
                .filter(x -> x.getName().equals(dishName))
                .findFirst();
        return dish.orElse(null);
    }
}
