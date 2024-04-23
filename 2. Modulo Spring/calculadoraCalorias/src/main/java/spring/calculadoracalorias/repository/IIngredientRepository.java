package spring.calculadoracalorias.repository;

import spring.calculadoracalorias.entity.Ingredient;

import java.util.List;

public interface IIngredientRepository {
    List<Ingredient> findAll();
    Ingredient getIngredientByName(String name);
}
