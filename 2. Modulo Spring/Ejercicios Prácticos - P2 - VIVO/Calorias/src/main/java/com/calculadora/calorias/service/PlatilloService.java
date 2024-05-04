package com.calculadora.calorias.service;

import com.calculadora.calorias.dto.IngredienteDTO;
import com.calculadora.calorias.dto.PlatilloCompletoDTO;
import com.calculadora.calorias.dto.PlatilloDTO;
import com.calculadora.calorias.entity.Ingrediente;
import com.calculadora.calorias.entity.Platillo;
import com.calculadora.calorias.repository.IIngredienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatilloService implements IPlatilloService{

    IIngredienteRepository ingredienteRepository;
    ObjectMapper mapper;

    public PlatilloService(IIngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
        mapper = new ObjectMapper();
    }

    @Override
    public PlatilloCompletoDTO getPlatillo(PlatilloDTO platilloDTO) {
        List<Platillo> platillos = ingredienteRepository.getTodosPlatillo();

        Platillo platillo = platillos.stream()
                .filter(p -> p.getName().equals(platilloDTO.getName()) && p.getWeight() == platilloDTO.getWeight())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Platillo no encontrado"));

        return mapper.convertValue(platillo, PlatilloCompletoDTO.class);
    }

    @Override
    public List<IngredienteDTO> getIngredientes() {
        List<Ingrediente> ingredientes = ingredienteRepository.getTodos();
        List<IngredienteDTO> ingredientesDTO = new ArrayList<>();
        for (Ingrediente ingrediente : ingredientes) {
            IngredienteDTO ingredienteDTO = mapper.convertValue(ingrediente, IngredienteDTO.class);
            ingredientesDTO.add(ingredienteDTO);
        }
        return ingredientesDTO;
    }

    @Override
    public List<PlatilloCompletoDTO> getPlatillos() {
        List<Platillo> platillos = ingredienteRepository.getTodosPlatillo();
        List<PlatilloCompletoDTO> platillosDTO = new ArrayList<>();
        for (Platillo platillo : platillos) {
            PlatilloCompletoDTO platilloDTO = mapper.convertValue(platillo, PlatilloCompletoDTO.class);
            platillosDTO.add(platilloDTO);
        }
        return platillosDTO;
    }

    @Override
    public List<PlatilloCompletoDTO> getPlatillosFilter(List<PlatilloDTO> platillos) {
        List<Platillo> platillosDB = ingredienteRepository.getTodosPlatillo();
        List<Platillo> platillosFilter = new ArrayList<>();
        for (PlatilloDTO platilloDTO : platillos) {
            Platillo platillo = platillosDB.stream()
                    .filter(p -> p.getName().equals(platilloDTO.getName()) && p.getWeight() == platilloDTO.getWeight())
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Platillo no encontrado"));
            platillosFilter.add(platillo);
        }
        return platillosFilter.stream().map(p -> mapper.convertValue(p, PlatilloCompletoDTO.class)).collect(Collectors.toList());
    }
}
