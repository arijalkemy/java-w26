package org.example.calculadoracalorias.service;

import org.example.calculadoracalorias.dto.IngredienteDTO;
import org.example.calculadoracalorias.dto.PlatoDTO;
import org.example.calculadoracalorias.dto.PlatoResponseDTO;
import org.example.calculadoracalorias.model.Plato;
import org.example.calculadoracalorias.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatoService {

    @Autowired
    private PlatoRepository platoRepository;

    public PlatoResponseDTO calcularCalorias(PlatoDTO platoDTO) {
        Plato plato = platoRepository.getAllPlatos().stream()
                .filter(p -> p.getName().equalsIgnoreCase(platoDTO.getName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Plato no encontrado"));

        List<IngredienteDTO> ingredientes = plato.getIngredients().stream()
                .map(i -> new IngredienteDTO(i.getName(), i.getCalories()))
                .collect(Collectors.toList());

        int totalCalories = ingredientes.stream()
                .mapToInt(IngredienteDTO::getCalories)
                .sum();

        IngredienteDTO highestCalorieIngredient = ingredientes.stream()
                .max(Comparator.comparingInt(IngredienteDTO::getCalories))
                .orElseThrow();

        return new PlatoResponseDTO(plato.getName(), totalCalories, ingredientes, highestCalorieIngredient);
    }

    public List<PlatoResponseDTO> calcularCaloriasDeLista(List<PlatoDTO> platosDTO) {
        return platosDTO.stream()
                .map(this::calcularCalorias)
                .collect(Collectors.toList());
    }
}
