package com.example.calculadoracalorias.service.impl;

import com.example.calculadoracalorias.DTO.PlatoRensposeDTO;
import com.example.calculadoracalorias.entity.Plato;
import com.example.calculadoracalorias.repository.IngredientesRepository;
import com.example.calculadoracalorias.service.ICalculadoraCaloriasService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalculadoraCaloriaServiceImpl implements ICalculadoraCaloriasService {

    public CalculadoraCaloriaServiceImpl() throws IOException {
    }

    List<Plato> platos = new ArrayList<>(List.of(
            new Plato("P1",List.of(IngredientesRepository.obtenerArchivo().get(0),IngredientesRepository.obtenerArchivo().get(2), IngredientesRepository.obtenerArchivo().get(4))),
            new Plato("P2",List.of(IngredientesRepository.obtenerArchivo().get(1),IngredientesRepository.obtenerArchivo().get(3), IngredientesRepository.obtenerArchivo().get(5))),
            new Plato("P3",List.of(IngredientesRepository.obtenerArchivo().get(0),IngredientesRepository.obtenerArchivo().get(1), IngredientesRepository.obtenerArchivo().get(2),
                    IngredientesRepository.obtenerArchivo().get(3), IngredientesRepository.obtenerArchivo().get(4), IngredientesRepository.obtenerArchivo().get(5))),
            new Plato("P4",List.of(IngredientesRepository.obtenerArchivo().get(6),IngredientesRepository.obtenerArchivo().get(7), IngredientesRepository.obtenerArchivo().get(10),
                    IngredientesRepository.obtenerArchivo().get(1), IngredientesRepository.obtenerArchivo().get(6), IngredientesRepository.obtenerArchivo().get(8)))));



    @Override
    public PlatoRensposeDTO calcularCalorias(String nombrePlato) {
        for(Plato plato: platos){
            if(plato.getNombre().equalsIgnoreCase(nombrePlato)){
                return new PlatoRensposeDTO(plato.getCalorias(), plato, plato.maxCalorias());
            }
        }
        throw new RuntimeException("Plato no encontrado");
    }
}
