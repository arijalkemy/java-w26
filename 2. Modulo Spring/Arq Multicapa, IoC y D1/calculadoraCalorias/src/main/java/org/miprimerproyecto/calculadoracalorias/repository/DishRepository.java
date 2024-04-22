package org.miprimerproyecto.calculadoracalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.miprimerproyecto.calculadoracalorias.model.Dish;
import org.miprimerproyecto.calculadoracalorias.model.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DishRepository implements IDishRepository{
    private final List<Ingredient> ingredients;
    private final List<Dish> listDish;

    public DishRepository() {
        this.ingredients=loadDataBase();
        this.listDish=createDish();
    }

    private List<Dish> createDish() {
        List<Dish> aux=new ArrayList<>();
        List<Ingredient> ingredientsPizza=new ArrayList<>();
        List<Ingredient> ingredientsPastelPapas=new ArrayList<>();
        ingredientsPizza.add(getIngredient("Queso mozzarella"));
        ingredientsPizza.add(getIngredient("Jamón"));
        ingredientsPizza.add(getIngredient("Harina de trigo refinada"));
        ingredientsPizza.add(getIngredient("Salsa de tomate en conserva"));
        ingredientsPastelPapas.add(getIngredient("Ternera"));
        ingredientsPastelPapas.add(getIngredient("Papas cocidas"));
        ingredientsPastelPapas.add(getIngredient("Huevo duro"));
        //Creamos la Lista de platos
        aux.add(new Dish("Pizza", ingredientsPizza, 350));
        aux.add(new Dish("PastelPapas", ingredientsPastelPapas, 750));
        return aux;

    }

    //cargamos
    private List<Ingredient> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("src/main/java/org/miprimerproyecto/calculadoracalorias/food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};
        List<Ingredient> ingredients = null;
        try {
            ingredients = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredients;
    }

    private Ingredient getIngredient(String name) {
        Ingredient aux=null;
        for (Ingredient ingredient : this.ingredients) {
            if (ingredient.getName().equals(name)) {
                aux = ingredient;
                break;
            }
        }
        return aux;
    }

    @Override
    public List<Dish> findAll() {
        return this.listDish;
    }

}
