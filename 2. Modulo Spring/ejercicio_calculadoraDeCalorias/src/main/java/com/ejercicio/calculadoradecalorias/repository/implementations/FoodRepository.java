package com.ejercicio.calculadoradecalorias.repository.implementations;

import com.ejercicio.calculadoradecalorias.entity.Food;
import com.ejercicio.calculadoradecalorias.entity.FoodIngredient;
import com.ejercicio.calculadoradecalorias.repository.interfaces.IRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@NoArgsConstructor
public class FoodRepository implements IRepository<Food> {
    private IngredientRepository ingredientRepository = new IngredientRepository();
    private List<Food> foodList = createFoods();

    @Override
    public List<Food> getAll() {
        return foodList;
    }

    @Override
    public Food getByName(String name) {
        Optional<Food> result = foodList
                .stream()
                .filter(food -> food.getName().equals(name))
                .findFirst();

        if (result.isPresent()) return result.get();
        return null;
    }

    private List<Food> createFoods() {
        List<Food> foodList = new ArrayList<Food>();

        foodList.add(new Food(
                "Milanesa a la Napolitana con Fritas",
                new ArrayList<FoodIngredient>(){{
                    add(new FoodIngredient(120, ingredientRepository.getByName("Ternera")));
                    add(new FoodIngredient(10, ingredientRepository.getByName("Pan de trigo blanco")));
                    add(new FoodIngredient(40, ingredientRepository.getByName("Queso mozzarella")));
                    add(new FoodIngredient(5, ingredientRepository.getByName("Salsa de tomate en conserva")));
                    add(new FoodIngredient(100, ingredientRepository.getByName("Papas fritas")));
                }}
        ));
        foodList.add(new Food(
                "Lomito completo",
                new ArrayList<FoodIngredient>(){{
                    add(new FoodIngredient(120, ingredientRepository.getByName("Ternera")));
                    add(new FoodIngredient(50, ingredientRepository.getByName("Pan de trigo blanco")));
                    add(new FoodIngredient(20, ingredientRepository.getByName("Queso mozzarella")));
                    add(new FoodIngredient(10, ingredientRepository.getByName("Mayonesa")));
                    add(new FoodIngredient(100, ingredientRepository.getByName("Papas fritas")));
                }}
        ));
        foodList.add(new Food(
                "Pizza de Mozzarella",
                new ArrayList<FoodIngredient>(){{
                    add(new FoodIngredient(70, ingredientRepository.getByName("Pan de trigo blanco")));
                    add(new FoodIngredient(200, ingredientRepository.getByName("Queso mozzarella")));
                    add(new FoodIngredient(50, ingredientRepository.getByName("Salsa de tomate en conserva")));
                    add(new FoodIngredient(40, ingredientRepository.getByName("Aceitunas verdes")));
                }}
        ));
        foodList.add(new Food(
                "Ensalada Caesar",
                new ArrayList<FoodIngredient>(){{
                    add(new FoodIngredient(100, ingredientRepository.getByName("Pollo")));
                    add(new FoodIngredient(160, ingredientRepository.getByName("Lechuga")));
                    add(new FoodIngredient(20, ingredientRepository.getByName("Anchoas")));
                    add(new FoodIngredient(115, ingredientRepository.getByName("Aceite de oliva")));
                    add(new FoodIngredient(50, ingredientRepository.getByName("Aceitunas negras")));
                    add(new FoodIngredient(10, ingredientRepository.getByName("Huevo entero")));
                    add(new FoodIngredient(5, ingredientRepository.getByName("Mostaza")));
                    add(new FoodIngredient(50, ingredientRepository.getByName("Queso parmesano")));
                }}
        ));
        foodList.add(new Food(
                "Tallarines con salsa Bolognesa",
                new ArrayList<FoodIngredient>(){{
                    add(new FoodIngredient(100, ingredientRepository.getByName("Pasta al huevo")));
                    add(new FoodIngredient(40, ingredientRepository.getByName("Ternera")));
                    add(new FoodIngredient(30, ingredientRepository.getByName("Salsa de tomate en conserva")));
                    add(new FoodIngredient(5, ingredientRepository.getByName("Ajos")));
                    add(new FoodIngredient(40, ingredientRepository.getByName("Cebolla")));
                    add(new FoodIngredient(40, ingredientRepository.getByName("Pimiento")));
                    add(new FoodIngredient(20, ingredientRepository.getByName("Zanahoria")));
                    add(new FoodIngredient(10, ingredientRepository.getByName("Aceite de oliva")));
                }}
        ));

        return foodList;
    }
}
