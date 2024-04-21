package com.example.ejercicio_arquitectura_multicapa_p2_vivo_calculadora_de_calorias.repository;

import com.example.ejercicio_arquitectura_multicapa_p2_vivo_calculadora_de_calorias.entity.Ingrediente;

import java.util.List;

public interface IIngredienteRepository {
    Integer findCaloriasDeIngrediente(String nombre);
    Ingrediente findIngredienteByName(String nombre);
    Ingrediente findIngredienteMasCalorias();
}
