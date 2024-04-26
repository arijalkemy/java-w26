package com.javabootcamp.calorias.service;

import com.javabootcamp.calorias.CaloriasApplication;
import com.javabootcamp.calorias.dto.CaloriesResponseDTO;
import com.javabootcamp.calorias.dto.IngredientDTO;
import com.javabootcamp.calorias.dto.Recipe;
import com.javabootcamp.calorias.model.Food;
import com.javabootcamp.calorias.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class CaloryService {
    @Autowired
    FoodRepository foodRepository;



    public List<Food> getAllIngredientes(){
        return foodRepository.getFoodList();
    }


    public CaloriesResponseDTO getRecipeInfo(Recipe recipe) {
        // Crear instancia de calories response
        CaloriesResponseDTO caloriesResponseDTO = new CaloriesResponseDTO();
        // Obtener la suma de calorias
        double totalSum = recipe.getFoodList().stream().mapToDouble(this::calorieByName).sum();
        caloriesResponseDTO.setTotalCalories(totalSum);
        // Obtener
        IngredientDTO maxCalory = recipe.getFoodList().stream().max(Comparator.comparingDouble(this::calorieByName)).orElse(null);
        caloriesResponseDTO.setBiggestCalory(maxCalory);
        caloriesResponseDTO.setFoodList(recipe.getFoodList());
        return caloriesResponseDTO;
    }

    public List<CaloriesResponseDTO> getRecipesInfo(List<Recipe> recipes){
        List<CaloriesResponseDTO> responses =  new ArrayList<>();
        for(Recipe recipe: recipes){
            responses.add(getRecipeInfo(recipe));
        }
        return responses;
    }

    private double calorieByName(IngredientDTO ingredientDTO){
        Optional<Food> foundFood = foodRepository.getFoodList().stream().filter(f->f.getName().equalsIgnoreCase(ingredientDTO.getName())).findFirst();
        if(foundFood.isPresent()){
            return ((foundFood.get().getCalories()*ingredientDTO.getWeight())/100);
        }
        else{
            return 0;
        }
    }

//    private PlatoResponseDto getPlatoResponseDto(PlatoRequestDto d) {
//        PlatoResponseDto platoResponseDto = new PlatoResponseDto();
//        platoResponseDto.setIngredients(d.getIngredientes());
//        platoResponseDto.setTotalCalorias(platoResponseDto.getIngredients().stream().mapToInt(this::calcularCalorias).sum());
//        platoResponseDto.setMostCaloricIngredient(platoResponseDto.getIngredients().stream().max(Comparator.comparingInt(this::calcularCalorias)).orElse(null));
//        return  platoResponseDto;
//    }




}
