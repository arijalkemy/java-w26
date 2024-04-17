package com.caloriescounter.caloriescounter.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.caloriescounter.caloriescounter.model.Ingredient;
import com.caloriescounter.caloriescounter.model.Plate;
import com.caloriescounter.utils.JSONManage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PlateRepository {
    
    private List<Ingredient> ingredientList;
    private List<Plate> plateList;

    public PlateRepository(){
        this.getIngredientListfromJSON();
        this.populatePlateList();
    }

    public void getIngredientListfromJSON(){
        String jsonFile = "food.json";
        try{
            String jsonContent = JSONManage.loadJsonFile(jsonFile);
            List<Ingredient> ingredientsFromJSON = JSONManage.deserializeJson(jsonContent);
            this.ingredientList = ingredientsFromJSON;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<Ingredient> fillIngredients(){
        String jsonFilePath = "";
        List<Ingredient> ingredientList = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();

        try {
            String json = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
            ingredientList = mapper.readValue(json, new TypeReference<List<Ingredient>>(){});

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ingredientList;
    }

    public List<Plate> populatePlateList(){
        List<Plate> plateList = new ArrayList<>();

        List<Ingredient> ingredientsPlate1 = new ArrayList<>();
        ingredientsPlate1.add(ingredientList.get(0));
        ingredientsPlate1.add(ingredientList.get(10));
        ingredientsPlate1.add(ingredientList.get(8));
        ingredientsPlate1.add(ingredientList.get(20));
        Plate plate1 = new Plate("Plate 1", ingredientsPlate1);

        List<Ingredient> ingredientsPlate2 = new ArrayList<>();
        ingredientsPlate2.add(ingredientList.get(5));
        ingredientsPlate2.add(ingredientList.get(7));
        ingredientsPlate2.add(ingredientList.get(43));
        ingredientsPlate2.add(ingredientList.get(68));
        Plate plate2 = new Plate("Plate 2", ingredientsPlate2);

        plateList.add(plate1);
        plateList.add(plate2);

        return plateList;
    }
}
