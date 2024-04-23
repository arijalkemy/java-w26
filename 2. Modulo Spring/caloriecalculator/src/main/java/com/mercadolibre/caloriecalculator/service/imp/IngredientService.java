package com.mercadolibre.caloriecalculator.service.imp;

import com.mercadolibre.caloriecalculator.entity.Ingredient;
import com.mercadolibre.caloriecalculator.repository.IngredientRepository;
import com.mercadolibre.caloriecalculator.service.IIngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService implements IIngredientService {
    private final IngredientRepository ingredientRepository;
    @Override
    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }
}
