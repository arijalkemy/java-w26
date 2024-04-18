package meli.bootcamp.calculadora.repository;
import meli.bootcamp.calculadora.entity.Food;
import meli.bootcamp.calculadora.entity.Ingredient;
import meli.bootcamp.calculadora.repository.interfaces.ICrud;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FoodRepository implements ICrud<Food> {
    
    private final List<Ingredient> ingredients = new IngredientsRepository().findAll();

    private final List<Food> foods = List.of(
            new Food("Pollo a la portuguesa", List.of(
                    ingredients.get(0),
                    ingredients.get(1),
                    ingredients.get(2)
            )),
            new Food("Milanesa con pure", List.of(
                    ingredients.get(3),
                    ingredients.get(4),
                    ingredients.get(5)
            )),
            new Food("Pizza", List.of(
                    ingredients.get(6),
                    ingredients.get(7),
                    ingredients.get(8),
                    ingredients.get(9)
            )),
            new Food("Empanada", List.of(
                    ingredients.get(10),
                    ingredients.get(11),
                    ingredients.get(12),
                    ingredients.get(14),
                    ingredients.get(15)
            ))
    );


    @Override
    public List<Food> findAll() {
        return foods;
    }
}
