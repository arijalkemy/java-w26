package spring.calculadoracalorias.repository;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import spring.calculadoracalorias.entity.Dish;
import spring.calculadoracalorias.entity.Ingredient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DishRepository implements IDishRepository {
    private List<Dish> dishes = new ArrayList<>();

    IngredientRepository ingredientRepository;

    public DishRepository() {
        this.ingredientRepository = new IngredientRepository();
        dishes = List.of(
                new Dish("Ensalada", 200, List.of(
                        ingredientRepository.getIngredientByName("tomates"),
                        ingredientRepository.getIngredientByName("lechuga")
                ))
        );
    }


    public Dish getDishByName(String name, double weight) {
        return this.dishes.stream().filter(d -> d.getName().equalsIgnoreCase(name) && d.getWeight() == weight).findFirst().orElse(null);
    }



}

