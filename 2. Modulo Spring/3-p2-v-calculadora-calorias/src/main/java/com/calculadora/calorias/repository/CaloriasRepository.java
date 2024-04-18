package com.calculadora.calorias.repository;

import com.calculadora.calorias.dto.IngredienteDTO;

public interface CaloriasRepository {

    IngredienteDTO findIngredienteByNombre(String nombreIngrediente);
}
