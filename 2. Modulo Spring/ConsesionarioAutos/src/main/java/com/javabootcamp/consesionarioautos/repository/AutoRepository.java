package com.javabootcamp.consesionarioautos.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javabootcamp.consesionarioautos.model.Auto;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AutoRepository {
    private List<Auto> foodList = new ArrayList<>();

    public AutoRepository(){
        this.foodList = loadAutosList();
    }

    private List<Auto> loadAutosList() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:autos.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Auto>> typeRef = new TypeReference<>() {
        };
        List<Auto> foods = null;
        try {
            foods = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return foods;
    }

    public List<Auto> getFoodList(){
        return this.foodList;
    }

    public void saveNewAuto(Auto newAuto) throws FileNotFoundException {
        foodList.add(newAuto);
        saveAutoList();
    }

    public void deleteAuto(int id) throws FileNotFoundException {
        foodList = foodList.stream().filter(a->a.getId()!=id).toList();
        saveAutoList();
    }

    private void saveAutoList() throws FileNotFoundException {
        ObjectMapper objectMapper = new ObjectMapper();
        String filePath = ResourceUtils.getFile("classpath:autos.json").getPath();

        try {
            // Write the object to the existing JSON file
            objectMapper.writeValue(new File(filePath), foodList);
            System.out.println("Object saved to " + filePath + " successfully.");
        } catch (IOException e) {
            System.err.println("Error occurred while saving the object to JSON file: " + e.getMessage());
        }
    }

}
