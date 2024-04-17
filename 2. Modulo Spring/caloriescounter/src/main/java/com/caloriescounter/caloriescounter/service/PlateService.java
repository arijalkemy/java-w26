package com.caloriescounter.caloriescounter.service;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caloriescounter.caloriescounter.dto.PlateDto;
import com.caloriescounter.caloriescounter.model.Ingredient;
import com.caloriescounter.caloriescounter.model.Plate;
import com.caloriescounter.caloriescounter.repository.PlateRepository;

@Service
public class PlateService implements IPlateService {

    @Autowired
    PlateRepository plateRepository;

    @Override
    public List<Plate> getAllPlates() {
        return plateRepository.populatePlateList();
    }
    
    @Override
    public PlateDto getPlateInformation(String dishName, int weight) {
        List<Plate> plateList = plateRepository.populatePlateList();

        Plate plate = plateList.stream().filter(dish -> dish.getPlateName().equals(dishName)).findFirst().orElse(null);
        PlateDto plateResponse = new PlateDto();
        plateResponse.setIngredients(plate.getPlateIngredients());
        plateResponse.setCalories(getAllCalories(plate) * (weight/100.0));
        plateResponse.setMostCalories(getMostCaloriesIngredient(plate));

        return plateResponse;
    }

    private int getAllCalories(Plate plate){
        int sum = 0;
        for(Ingredient ingr: plate.getPlateIngredients()){
            sum += ingr.getCalories();
        }
        return sum;
    }

    protected String getMostCaloriesIngredient(Plate plate){
        List<Ingredient> ingredients = plate.getPlateIngredients();
        return Collections.max(ingredients, Comparator.comparing(ingr -> ingr.getCalories())).getName();
    }
}
