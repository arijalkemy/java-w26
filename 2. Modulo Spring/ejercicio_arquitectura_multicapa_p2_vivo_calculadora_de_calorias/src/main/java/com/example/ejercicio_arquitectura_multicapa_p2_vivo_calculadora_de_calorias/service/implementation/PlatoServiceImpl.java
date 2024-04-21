package com.example.ejercicio_arquitectura_multicapa_p2_vivo_calculadora_de_calorias.service.implementation;

import com.example.ejercicio_arquitectura_multicapa_p2_vivo_calculadora_de_calorias.dto.InformacionPlatoResponseDto;
import com.example.ejercicio_arquitectura_multicapa_p2_vivo_calculadora_de_calorias.dto.IngredienteDto;
import com.example.ejercicio_arquitectura_multicapa_p2_vivo_calculadora_de_calorias.entity.Ingrediente;
import com.example.ejercicio_arquitectura_multicapa_p2_vivo_calculadora_de_calorias.repository.IIngredienteRepository;
import com.example.ejercicio_arquitectura_multicapa_p2_vivo_calculadora_de_calorias.repository.IPlatoRepository;
import com.example.ejercicio_arquitectura_multicapa_p2_vivo_calculadora_de_calorias.service.IPlatoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PlatoServiceImpl implements IPlatoService {
    private IPlatoRepository platoRepository;
    private IIngredienteRepository ingredienteRepository;

    public PlatoServiceImpl(IPlatoRepository platoRepository, IIngredienteRepository ingredienteRepository) {
        this.platoRepository = platoRepository;
        this.ingredienteRepository = ingredienteRepository;
    }

    public InformacionPlatoResponseDto searchInformacion(String nombre, Integer peso) {
        List<String> nombresIngredientes = platoRepository.findIngredientes(nombre);
        List<Integer> caloriasIngredientes = new ArrayList<>();
        List<Ingrediente> ingredientes = new ArrayList<>();

        for(String nombreIngrediente : nombresIngredientes) {
            caloriasIngredientes.add(
                    ingredienteRepository.findCaloriasDeIngrediente(nombreIngrediente)
            );
            ingredientes.add(
                ingredienteRepository.findIngredienteByName(nombreIngrediente)
            );
        }

        double caloriasTotales = (caloriasIngredientes.stream()
                .mapToInt(Integer::intValue).sum()) * ((double) peso / 100);

        ObjectMapper mapper = new ObjectMapper();
        List<IngredienteDto> ingredientesDto = ingredientes.stream().map(
            ingrediente -> mapper.convertValue(ingrediente, IngredienteDto.class)
        ).toList();

        IngredienteDto ingredienteMasCaloriasDto = ingredientesDto.stream()
            .max(Comparator.comparing(IngredienteDto::getCalories)).get();

        InformacionPlatoResponseDto informacionPlatoResponseDto = new InformacionPlatoResponseDto(
            caloriasTotales,
            ingredientesDto,
            ingredienteMasCaloriasDto
        );

        return informacionPlatoResponseDto;
    }
}
