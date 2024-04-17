package com.meli.calculadoraDeCalorias.repository;

import com.meli.calculadoraDeCalorias.model.Dish;
import com.meli.calculadoraDeCalorias.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DishRepositoryImpl implements IRepository<Dish>{
    private List<Dish> dishes;

    private IRepository<Ingredient> ingredientRepository;

    public DishRepositoryImpl() {
        this.ingredientRepository = new IngredientRepositoryImpl();
        this.dishes = List.of(
                new Dish("Repollo al Spiedo", List.of(ingredientRepository.findByName("Repollo"),
                        ingredientRepository.findByName("Aceitunas negras"))),
                new Dish("B", List.of(ingredientRepository.findByName("Tomates"),
                        ingredientRepository.findByName("Puerros"))));
    }


    @Override
    public List<Dish> findAll() {
        return this.dishes;
    }

    @Override
    public Dish findByName(String name) {
        return dishes.stream().filter(dish -> dish.getName().equalsIgnoreCase(name)).findAny().orElse(null);
    }
}
