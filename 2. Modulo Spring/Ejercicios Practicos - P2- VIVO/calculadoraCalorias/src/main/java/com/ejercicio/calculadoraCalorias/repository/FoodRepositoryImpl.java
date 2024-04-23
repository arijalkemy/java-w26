package com.ejercicio.calculadoraCalorias.repository;

import com.ejercicio.calculadoraCalorias.model.Dish;
import com.ejercicio.calculadoraCalorias.model.Food;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FoodRepositoryImpl implements IFoodRepository {


    List<Food> foodList;
    List<Dish> dishList;



    public FoodRepositoryImpl(){
        readJsonFood();
        createDish();
    }



    @Override
    public List<Food> getAll() {
        return this.foodList;
    }

    public Dish getDishListByName(String name) {
        List<Dish> dishListFilter = this.dishList.stream().filter(Dish -> Dish.getName().equals(name)).toList();
        if(dishListFilter.size()== 0){
            return null;
        }

        Dish dishResult = dishListFilter.get(0);
        return dishResult;
    }

    private void readJsonFood()  {

        try {
            String pathJsonFood = "src/main/resources/food.json";
            ObjectMapper mapper = new ObjectMapper();

            CollectionType listType = mapper.getTypeFactory().constructCollectionType(List.class, Food.class);
            List<Food> foodList = mapper.readValue(new File(pathJsonFood), listType);
            this.foodList = foodList;

        } catch (IOException e){
            System.out.println("Error" + e.getMessage());
        }


    }

    private void createDish(){

        this.dishList = new ArrayList<>();
        this.dishList.add(new Dish("Pizza", 15.5, this.foodList.subList(1,10)));
        this.dishList.add(new Dish("Ensalada", 17.8, this.foodList.subList(15,20)));
        this.dishList.add(new Dish("Pasta", 20.0, this.foodList.subList(20,25)));




    }


}
