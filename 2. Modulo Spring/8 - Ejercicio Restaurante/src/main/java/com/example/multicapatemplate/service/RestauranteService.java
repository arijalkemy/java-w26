package com.example.multicapatemplate.service;

import com.example.multicapatemplate.dto.IngredienteDto;

import java.util.List;

public interface RestauranteService {

//    Cantidad total de calorías del plato
//    Lista de ingredientes que lo conforman y cantidad de calorías de cada uno de ellos
//    El ingrediente con mayor cantidad de calorías

    double obtenerCalorias(String plato );

    List<IngredienteDto> obtenerIngredientes(String plato );

    String ingredienteCalorico(String plato );
}
