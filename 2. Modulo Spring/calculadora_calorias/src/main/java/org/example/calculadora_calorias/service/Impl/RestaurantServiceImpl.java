package org.example.calculadora_calorias.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.calculadora_calorias.dto.IngredientDTO;
import org.example.calculadora_calorias.dto.PlateDTO;
import org.example.calculadora_calorias.model.Ingredient;
import org.example.calculadora_calorias.model.Plate;
import org.example.calculadora_calorias.repository.IPlateRepository;
import org.example.calculadora_calorias.repository.IngredientRepository;
import org.example.calculadora_calorias.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

@Service
public class RestaurantServiceImpl implements IRestaurantService {

    @Autowired
    IPlateRepository plateRepository;
    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public Integer plateCalories(String plate) {
        List< IngredientDTO> ingredients = plateRepository.findByName(plate).getIngredients();
        return ingredients.stream().mapToInt(IngredientDTO::getCalories).sum();
    }

    @Override
    public Plate listOfIngredients(String plate) {
        return plateRepository.findByName(plate);
    }

    @Override
    public Ingredient ingredientCalories(String plateName) {
        ObjectMapper mapper = new ObjectMapper();
        Plate plate = this.plateRepository.findByName(plateName);
        Integer maxCalories = plate.getIngredients().stream().mapToInt(x->x.getCalories()).max().orElse(-1);
        IngredientDTO ingredient =  plate.getIngredients()
                .stream()
                .filter(x->x.getCalories().equals(maxCalories))
                .findFirst().orElse(null);
        return ingredientRepository.findByName(ingredient.getName());
    }

    @Override
    public List<PlateDTO> platesCalories(String plates) {
        List<String> platesNames = Arrays.stream(plates.split(",")).toList();
        List<PlateDTO> plateResponse = new ArrayList<>();
        if(platesNames.isEmpty()) return plateResponse;
        platesNames.forEach(plateName->{
            plateResponse.add(new PlateDTO(plateRepository.findByName(plateName.trim())));
                });
        return plateResponse;
    }
}
