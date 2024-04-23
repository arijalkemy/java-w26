package com.demospring.calculadoradecalorias.service;

import com.demospring.calculadoradecalorias.dto.IngredienteDTO;
import com.demospring.calculadoradecalorias.dto.PlatoRequestDTO;
import com.demospring.calculadoradecalorias.dto.PlatoResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Restaurante implements IRestaurante{
    @Override
    public PlatoResponseDTO getCaloriasPlato(PlatoRequestDTO platoRequestDTO) {
        int caloriasTotal = 0;
        for(IngredienteDTO ingrediente : platoRequestDTO.getIngredientes()){
            caloriasTotal += ingrediente.getCalories();
        }
        return new PlatoResponseDTO(platoRequestDTO.getNombre(), caloriasTotal);
    }

    @Override
    public List<PlatoResponseDTO> getCaloriasPlatos(List<PlatoRequestDTO> platos) {
        List<PlatoResponseDTO> caloriasPlatos = new ArrayList<>();
        for(PlatoRequestDTO plato : platos){
            caloriasPlatos.add(getCaloriasPlato(plato));
        }
        return caloriasPlatos;
    }
}
