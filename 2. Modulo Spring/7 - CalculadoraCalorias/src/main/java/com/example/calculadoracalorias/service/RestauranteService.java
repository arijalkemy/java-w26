package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.IngredienteDTO;
import com.example.calculadoracalorias.model.Plato;
import com.example.calculadoracalorias.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestauranteService{
    @Autowired
    RestauranteRepository repository;

    public List<IngredienteDTO> verIngredientes() {
        List<IngredienteDTO> ingredienteDTOS = new ArrayList<>();
        repository.verIngredientes().stream()
                .forEach(p-> ingredienteDTOS.add(new IngredienteDTO(p.getNombre(),p.getCalorias())));
        return ingredienteDTOS;
    }

    public Plato verPlato(@PathVariable String nombre) {
        return repository.verPlato(nombre);
    }
}
