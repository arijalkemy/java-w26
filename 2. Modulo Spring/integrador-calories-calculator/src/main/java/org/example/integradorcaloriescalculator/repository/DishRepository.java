package org.example.integradorcaloriescalculator.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.example.integradorcaloriescalculator.entity.Ingredient;
import org.example.integradorcaloriescalculator.entity.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Repository
public class DishRepository implements IDishRepository<Ingredient>{

    private List<Dish> dishes;
    private List<Ingredient> ingredients;

    private final ResourceLoader resourceLoader;

    @Autowired
    public DishRepository(ResourceLoader resourceLoader) throws IOException{
        this.resourceLoader = resourceLoader;
        dishes = new ArrayList<>();
        dishes = loadDefaultDishes();

    }


    public List<Dish> loadDefaultDishes() throws IOException{

        List <Dish> dishesToAdd = new ArrayList<>();
        loadIngredients();

        List<Ingredient> ingredients1 = new ArrayList<>(){{
            add(ingredients.stream().filter(i -> i.getName().equals("Cereza")).findFirst().get());
            add(ingredients.stream().filter(i -> i.getName().equals("Coco")).findFirst().get());
            add(ingredients.stream().filter(i -> i.getName().equals("Frambuesa")).findFirst().get());
            add(ingredients.stream().filter(i -> i.getName().equals("Mango")).findFirst().get());
        }};

        Dish dish1 = new Dish("Ensalada de Frutas", ingredients1);
        dishesToAdd.add(dish1);

        List<Ingredient> ingredients2 = new ArrayList<>(){{
            add(ingredients.stream().filter(i -> i.getName().equals("Queso blanco desnatado")).findFirst().get());
            add(ingredients.stream().filter(i -> i.getName().equals("Butifarra cocida")).findFirst().get());
            add(ingredients.stream().filter(i -> i.getName().equals("Pato")).findFirst().get());
            add(ingredients.stream().filter(i -> i.getName().equals("Pavo, Pechuga")).findFirst().get());
        }};

        Dish dish2 = new Dish("Picada de carnes con queso", ingredients2);
        dishesToAdd.add(dish2);

        List<Ingredient> ingredients3 = new ArrayList<>(){{
            add(ingredients.stream().filter(i -> i.getName().equals("Lomo embuchado")).findFirst().get());
            add(ingredients.stream().filter(i -> i.getName().equals("Jamón cocido")).findFirst().get());
            add(ingredients.stream().filter(i -> i.getName().equals("Pan de centeno")).findFirst().get());
            add(ingredients.stream().filter(i -> i.getName().equals("Queso cheddar")).findFirst().get());
        }};

        Dish dish3 = new Dish("Sandwich de lomo", ingredients3);
        dishesToAdd.add(dish3);

        List<Ingredient> ingredients4 = new ArrayList<>(){{
            add(ingredients.stream().filter(i -> i.getName().equals("Huevo duro")).findFirst().get());
            add(ingredients.stream().filter(i -> i.getName().equals("Mayonesa")).findFirst().get());
            add(ingredients.stream().filter(i -> i.getName().equals("Mostaza")).findFirst().get());
        }};

        Dish dish4 = new Dish("Puré de huevo en salsa", ingredients4);
        dishesToAdd.add(dish4);

        return dishesToAdd;

    }


    public List<Ingredient> loadIngredients() throws IOException{
        ingredients = loadData();
        return ingredients;
    }



    @Override
    public List<Ingredient> loadData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Resource resource = resourceLoader.getResource("classpath:food.json");
        InputStream inputStream = resource.getInputStream();
        try {
            return mapper.readValue(inputStream, new TypeReference<List<Ingredient>>() {});
        } finally {
            inputStream.close();
        }
    }



}
