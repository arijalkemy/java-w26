package com.calculadora.calorias.service.impl;

import com.calculadora.calorias.dto.IngredienteDTO;
import com.calculadora.calorias.dto.PlatoInputDTO;
import com.calculadora.calorias.dto.PlatoResponseDTO;
import com.calculadora.calorias.repository.CaloriasRepository;
import com.calculadora.calorias.service.CaloriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaloriasServiceImpl implements CaloriasService {

    @Autowired
    CaloriasRepository caloriasRepository;

    public CaloriasServiceImpl(CaloriasRepository caloriasRepository) {
        this.caloriasRepository = caloriasRepository;
    }

    @Override
    public List<PlatoResponseDTO> calcularTotalCalorias(List<PlatoInputDTO> platoInputDTO) {
        List<PlatoResponseDTO> resultado = new ArrayList<>();
        for (PlatoInputDTO plato : platoInputDTO) {
            resultado.add(this.calcularCalorias(plato));
        }
        return resultado;
    }

    @Override
    public PlatoResponseDTO calcularCalorias(PlatoInputDTO platoInputDTO) {
        PlatoResponseDTO response = new PlatoResponseDTO(platoInputDTO);
        int total = 0;
        int maxCalories = 0;
        for (IngredienteDTO ingrediente : response.getIngredienteList()) {
            calculateIngredientCalories(ingrediente);
            total += ingrediente.getCalorias();
            if (ingrediente.getCalorias() > maxCalories) {
                response.setCaloric(ingrediente);
                maxCalories = ingrediente.getCalorias();
            }
        }
        response.setCalorias(total);
        return response;
    }



    private void calculateIngredientCalories(IngredienteDTO ingredient) {
        ingredient.setCalorias(0);
        IngredienteDTO ingredientFromRepository = caloriasRepository.findIngredienteByNombre(ingredient.getNombre());
        if (ingredientFromRepository != null)
            ingredient.setCalorias((int) (ingredient.getPeso() * ingredientFromRepository.getCalorias() / 100.f));
    }
}
