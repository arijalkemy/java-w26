package com.example.calculadora_calorias.repository.FoodRepository;

import com.example.calculadora_calorias.entity.Ingrediente;

import java.util.Optional;

public interface IFoodRepository {
    Optional<Ingrediente> findByName(String name);
}
