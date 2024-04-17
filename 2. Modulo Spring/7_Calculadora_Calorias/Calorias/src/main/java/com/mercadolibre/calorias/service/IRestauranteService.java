package com.mercadolibre.calorias.service;

import com.mercadolibre.calorias.dto.IngredienteDTO;
import com.mercadolibre.calorias.dto.PlatoDTO;
import com.mercadolibre.calorias.model.Plato;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IRestauranteService {

    public List<IngredienteDTO> verIngredientes();
    public PlatoDTO verPlato(String nombre);
}
