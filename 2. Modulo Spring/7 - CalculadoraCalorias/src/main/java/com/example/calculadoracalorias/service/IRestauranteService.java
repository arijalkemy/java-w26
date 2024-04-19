package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.IngredienteDTO;
import com.example.calculadoracalorias.model.Plato;

import java.util.List;

public interface IRestauranteService{
    List<IngredienteDTO> verIngredientes();
    Plato verPlato();
}
