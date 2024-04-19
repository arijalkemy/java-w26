package com.w26.countercalories.repository;

import com.w26.countercalories.entity.Dish;
import com.w26.countercalories.entity.Ingredient;
import com.w26.countercalories.entity.IngredientDish;
import com.w26.countercalories.entity.Portion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientDishRepository {

    private List<IngredientDish> ingredientDishList = null;

    private final IngredientRepository ingredientRepository;

    public IngredientDishRepository(IngredientRepository ingredientRepository)
    {
        this.ingredientRepository = ingredientRepository;

        if (ingredientDishList == null)
        {
            this.loadIngredientDish();
        }

    }

    public List<IngredientDish> getIngredientDishList() {
        return ingredientDishList;
    }

    public void addIngredientDishList(IngredientDish ingredientDish){
        ingredientDishList.add(ingredientDish);
    }

    private void loadIngredientDish()
    {
        this.ingredientDishList = new ArrayList<>();
        Ingredient i1 = ingredientRepository.ingredientByName("Arroz blanco");
        Ingredient i2 = ingredientRepository.ingredientByName("Pollo, Muslo");
        Ingredient i3 = ingredientRepository.ingredientByName("Salchicha Frankfurt");

        List<Portion> porciones = new ArrayList<>();
        porciones.add(Portion.of(i1, 50));
        porciones.add(Portion.of(i2, 30));
        porciones.add(Portion.of(i3, 20));

        IngredientDish arrozConPollo = new IngredientDish(new Dish("Arroz con pollo", 400), porciones);
        ingredientDishList.add(arrozConPollo);
    }
}
