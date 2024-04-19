package com.example.multicapatemplate.service;

import com.example.multicapatemplate.model.Ingrediente;

import java.util.List;

public interface RestauranteService {

//    Cantidad total de calorías del plato
//    Lista de ingredientes que lo conforman y cantidad de calorías de cada uno de ellos
//    El ingrediente con mayor cantidad de calorías

    int obtenerCalorias( String plato );

    List<Ingrediente> obtenerIngredientes(String plato );

    Ingrediente ingredienteCalorico( String plato );
}
