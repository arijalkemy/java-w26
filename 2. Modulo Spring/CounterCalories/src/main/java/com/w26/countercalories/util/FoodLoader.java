package com.w26.countercalories.util;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.w26.countercalories.entity.Ingredient;
import lombok.extern.java.Log;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Log
@Component
public class FoodLoader {

    private static List<Ingredient> ingredientListGlobal;
    private List<Ingredient> ingredientList;

    public FoodLoader()
    {
        if (ingredientList == null)
        {
            loadFood();
        }
        ingredientList = ingredientListGlobal;
    }

    public List<Ingredient> getIngredientList(){
        return  this.ingredientList;
    }

    private static void loadFood()
    {
        Resource resourceFoodJson = new ClassPathResource("food.json");
        ObjectMapper mapper = new ObjectMapper();

        try {
            File fileJson = resourceFoodJson.getFile();
            FoodLoader.ingredientListGlobal = mapper.readValue(fileJson, MapFood.class).getIngredientList();
            log.fine("INGREDIENTES AGREGADOS");
        } catch (DatabindException e) {
            System.out.println(e);
        } catch (IOException e)
        {
            System.out.println(e);
        }
    }
}
