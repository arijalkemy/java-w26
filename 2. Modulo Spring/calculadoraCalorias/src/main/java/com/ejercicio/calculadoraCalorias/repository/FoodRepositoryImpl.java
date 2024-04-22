package com.ejercicio.calculadoraCalorias.repository;

import com.ejercicio.calculadoraCalorias.model.Dish;
import com.ejercicio.calculadoraCalorias.model.Food;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class FoodRepositoryImpl implements IFoodRepository {

    public FoodRepositoryImpl(){
        readJsonFood();
        createDish();
    }

    List<Food> foodList;
    List<Dish> dishList;

    @Override
    public List<Food> getAll() {
        return this.foodList;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    private void readJsonFood()  {

        try {
            String pathJsonFood = "src/main/resources/food.json";
            ObjectMapper mapper = new ObjectMapper();
            List<Food> foodList = mapper.readValue(new File(pathJsonFood),List.class);
            this.foodList = foodList;
            System.out.println("Entro al metodo");
            System.out.println(foodList);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }


    }

    private void createDish(){


        this.dishList.add(new Dish("Pizza", 15.5, this.foodList.subList(1,10)));
        this.dishList.add(new Dish("Ensalada", 17.8, this.foodList.subList(15,20)));
        this.dishList.add(new Dish("Pasta", 20.0, this.foodList.subList(20,25)));




    }


}
