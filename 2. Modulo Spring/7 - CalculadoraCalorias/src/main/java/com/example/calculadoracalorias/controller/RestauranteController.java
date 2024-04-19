package com.example.calculadoracalorias.controller;

import com.example.calculadoracalorias.dto.IngredienteDTO;
import com.example.calculadoracalorias.model.Plato;
import com.example.calculadoracalorias.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestauranteController {
    @Autowired
    RestauranteService restauranteService;

    @GetMapping("/ingredientes")
    public List<IngredienteDTO> verIngredientes(){
        return restauranteService.verIngredientes();
    }

    @GetMapping("/plato/{nombre}")
    public Plato verPlato(@PathVariable String nombre){
        return restauranteService.verPlato(nombre);
    }

}

