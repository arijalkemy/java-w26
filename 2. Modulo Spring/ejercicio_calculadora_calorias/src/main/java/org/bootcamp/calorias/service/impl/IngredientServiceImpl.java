package org.bootcamp.calorias.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bootcamp.calorias.dto.DishResponseDTO;
import org.bootcamp.calorias.dto.IngredientDTO;
import org.bootcamp.calorias.model.Ingredient;
import org.bootcamp.calorias.repository.IngredientRepository;
import org.bootcamp.calorias.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public List<IngredientDTO> getAll() {
        return ingredientRepository.findAll().stream()
                .map(ingredient -> objectMapper.convertValue(ingredient, IngredientDTO.class))
                .toList();
    }

    @Override
    public IngredientDTO getHighest(List<Ingredient> ingredients) {
        return objectMapper.convertValue(ingredients.stream()
                .max(Comparator.comparingInt(Ingredient::getCalories)), IngredientDTO.class);
    }
}
