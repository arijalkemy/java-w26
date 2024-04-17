package com.mercadolibre.calorias.service;

import com.mercadolibre.calorias.dto.IngredienteDTO;
import com.mercadolibre.calorias.dto.PlatoDTO;
import com.mercadolibre.calorias.model.Ingrediente;
import com.mercadolibre.calorias.model.Plato;
import com.mercadolibre.calorias.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestauranteService {

    @Autowired
    RestauranteRepository _repository;

    public List<IngredienteDTO> verIngredientes(){
        List<IngredienteDTO> ingredienteDTOS = new ArrayList<>();
        _repository.verIngredientes()
                .stream()
                .forEach(i -> ingredienteDTOS.add(new IngredienteDTO(i.getNombre(), i.getCalorias())));
        return ingredienteDTOS;
    }

    public PlatoDTO verPlato(@PathVariable String nombre){
        Plato plato =_repository.verPlato(nombre);
        List<Ingrediente> ingredientes = plato.getIngredientes();
        List<IngredienteDTO> ingredientesDTO = new ArrayList<>();
        ingredientes.stream().forEach(i -> ingredientesDTO.add(new IngredienteDTO(i.getNombre(), i.getCalorias())));
        return new PlatoDTO(plato.getNombre(), ingredientesDTO);
    }
}
