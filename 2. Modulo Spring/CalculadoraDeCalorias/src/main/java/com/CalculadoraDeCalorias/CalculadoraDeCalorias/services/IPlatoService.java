package com.CalculadoraDeCalorias.CalculadoraDeCalorias.services;

import com.CalculadoraDeCalorias.CalculadoraDeCalorias.dto.IngredienteDTO;
import com.CalculadoraDeCalorias.CalculadoraDeCalorias.dto.PlatoIngredientesDTO;


import java.util.List;

public interface IPlatoService {
    public int obtenerPlato(String nombre);
    public List<PlatoIngredientesDTO> obtenerListaIngredientes(String nombre);
    public IngredienteDTO obtenerIngredienteMayorCaloria(String nombre);
}
