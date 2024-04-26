package org.example.calorias.service;

import org.example.calorias.dto.PlatoDTO;
import org.example.calorias.dto.PlatoIngredienteDTO;
import org.example.calorias.dto.PlatoIngredientesDTO;

import java.util.List;

public interface IPlatos {
    List<PlatoDTO> caloriasPlatos();
    List<PlatoIngredientesDTO> ingredientesPlatos();
    List<PlatoIngredienteDTO> ingredienteMayorCaloriasPlatos();
}
