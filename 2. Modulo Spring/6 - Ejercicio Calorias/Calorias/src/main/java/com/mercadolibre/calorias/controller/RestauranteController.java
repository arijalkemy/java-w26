package com.mercadolibre.calorias.controller;

import com.mercadolibre.calorias.dto.IngredienteDTO;
import com.mercadolibre.calorias.dto.PlatoDTO;
import com.mercadolibre.calorias.model.Plato;
import com.mercadolibre.calorias.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestauranteController {

    @Autowired
    RestauranteService _service;

    @GetMapping("/ingredientes")
    public List<IngredienteDTO> verIngredientes(){
        return _service.verIngredientes();
    }

    @GetMapping("/plato/{nombre}")
    public PlatoDTO verPlato(@PathVariable String nombre){
        return _service.verPlato(nombre);
    }

}
