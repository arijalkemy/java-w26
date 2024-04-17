package com.meli.calculadoraDeCalorias.repository;

import com.meli.calculadoraDeCalorias.dto.DishResponseDTO;
import com.meli.calculadoraDeCalorias.model.Dish;
import com.meli.calculadoraDeCalorias.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DishRepository implements IRepository<Dish> {

    private IRepository<Ingredient> ingredientRepository;
    private List<Dish> dishes;

    public DishRepository() {
        ingredientRepository = new IngredientRepository();
        loadDataBase();
    }

    private void loadDataBase() {
        this.dishes = new ArrayList<>();
        List<Ingredient> listIngredients = ingredientRepository.getAll();

        if (listIngredients.size() > 0) {
            Ingredient ingredientOne = listIngredients.stream().findAny().orElse(null);
            Ingredient ingredientTwo = listIngredients.stream().findAny().orElse(null);
            Ingredient ingredientThree = listIngredients.stream().findAny().orElse(null);

            dishes.add(new Dish("Primero",List.of(ingredientOne, ingredientThree), 400.0));
            dishes.add(new Dish("Segundo",List.of(ingredientTwo, ingredientThree), 500.0));
            dishes.add(new Dish("Tercero",List.of(ingredientOne, ingredientTwo), 600.0));
        }


    }

    @Override
    public List<Dish> getAll() {
        return this.dishes;
    }

    @Override
    public Dish getByName(String name) {
        return this.dishes.stream()
                .filter(d -> d.getName().equalsIgnoreCase(name))
                .findAny().orElse(null);
    }


}
