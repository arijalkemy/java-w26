package com.bootcamp.c3calculadoracalorias.service;

import com.bootcamp.c3calculadoracalorias.dto.PlatoDTO;
import com.bootcamp.c3calculadoracalorias.repository.IngredienteRepositoryImpl;

public class ComidasServiceImpl implements IComidasService{
    IngredienteRepositoryImpl ingredienteRepository;
    @Override
    public Integer caloriasPlato(PlatoDTO plato) {
        Integer caloriasTotales;
        caloriasTotales = ingredienteRepository.encontrarIngrediente(plato.getNombre()).getCalorias();
        return caloriasTotales;
    }
}
