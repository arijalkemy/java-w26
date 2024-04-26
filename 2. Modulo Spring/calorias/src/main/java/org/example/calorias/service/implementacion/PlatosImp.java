package org.example.calorias.service.implementacion;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.calorias.dto.IngredienteDTO;
import org.example.calorias.dto.PlatoDTO;
import org.example.calorias.dto.PlatoIngredienteDTO;
import org.example.calorias.dto.PlatoIngredientesDTO;
import org.example.calorias.entity.Ingrediente;
import org.example.calorias.entity.Plato;
import org.example.calorias.repository.PlatosRepository;
import org.example.calorias.service.IPlatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PlatosImp implements IPlatos {

    @Autowired
    private PlatosRepository platosRepository;

    @Override
    public List<PlatoDTO> caloriasPlatos() {
        List<PlatoDTO> peticionesPlatoDTOS = new ArrayList<>();
        System.out.println(platosRepository.obtenerPlatos());
        for (Plato plato: platosRepository.obtenerPlatos()){
            peticionesPlatoDTOS.add(new PlatoDTO(plato.getName(),
                    plato.getIngredients().stream().mapToInt(Ingrediente::getCalories).sum()));
        }
        return peticionesPlatoDTOS;
    }

    @Override
    public List<PlatoIngredientesDTO> ingredientesPlatos() {
        List<PlatoIngredientesDTO> ingredientesPlatoDTOS = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        for (Plato plato: platosRepository.obtenerPlatos()){
            ingredientesPlatoDTOS.add(
                    new PlatoIngredientesDTO(plato.getName(),
                    plato.getIngredients().stream().map(p -> objectMapper.convertValue(p, IngredienteDTO.class)).toList()
            ));
        }

        return ingredientesPlatoDTOS;
    }

    @Override
    public List<PlatoIngredienteDTO> ingredienteMayorCaloriasPlatos() {
        List<PlatoIngredienteDTO> ingredientesPlatoDTOS = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        for (Plato plato: platosRepository.obtenerPlatos()){
            Ingrediente ingrediente = plato.getIngredients().stream()
                    .max(Comparator.comparingInt(Ingrediente::getCalories)).get();
            ingredientesPlatoDTOS.add(new PlatoIngredienteDTO(plato.getName(),
                    objectMapper.convertValue(ingrediente, IngredienteDTO.class)));
        }
        return ingredientesPlatoDTOS;
    }
}
