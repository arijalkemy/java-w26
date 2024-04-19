package com.example.calculadora.calculadora_calorias.service;

import com.example.calculadora.calculadora_calorias.entity.Ingredient;
import com.example.calculadora.calculadora_calorias.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    IRepository<Ingredient> ingredientIRepository;

    @Autowired
    public IngredientService(IRepository<Ingredient> ingredientIRepository) {
        this.ingredientIRepository = ingredientIRepository;
    }

    public List<Ingredient> findAll(){
        return ingredientIRepository.getAll();
    }
}
