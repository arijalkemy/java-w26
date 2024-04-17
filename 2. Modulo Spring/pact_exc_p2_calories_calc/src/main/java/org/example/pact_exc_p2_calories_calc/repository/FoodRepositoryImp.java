package org.example.pact_exc_p2_calories_calc.repository;

import com.google.gson.Gson;
import org.example.pact_exc_p2_calories_calc.entity.FoodEntity;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class FoodRepositoryImp implements IFoodRepository{
    private List<FoodEntity> foodList = new ArrayList<>();

    public FoodRepositoryImp() {
        String filePath = "src/main/resources/static/food.json";
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader(filePath);
            this.foodList = Arrays.stream(gson.fromJson(reader, FoodEntity[].class)).toList();
        } catch (IOException ex) {
            ex.getCause();
        }
    }

    @Override
    public List<FoodEntity> getAllFood() {
        return this.foodList;
    }
}
