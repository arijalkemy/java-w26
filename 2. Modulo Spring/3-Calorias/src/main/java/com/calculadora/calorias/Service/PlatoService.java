package com.calculadora.calorias.Service;

import com.calculadora.calorias.Dto.IngredienteDto;
import com.calculadora.calorias.Dto.ListaDeIngredientesDto;
import com.calculadora.calorias.Dto.PlatoRequestDto;
import com.calculadora.calorias.Dto.PlatoResponseDto;
import com.calculadora.calorias.Entity.Ingrediente;
import com.calculadora.calorias.Entity.Plato;
import com.calculadora.calorias.Exception.DishNotFoundException;
import com.calculadora.calorias.Repository.Interface.IPlatoRepository;
import com.calculadora.calorias.Service.Interface.IPlatoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlatoService implements IPlatoService {

    @Autowired
    IPlatoRepository platoRepository;

    @Override
    public PlatoResponseDto getCalorias(PlatoRequestDto requestDto){
        Optional<Plato> plato = platoRepository.getByName(requestDto.getName());
        if(!plato.isPresent()){
            throw new DishNotFoundException("No se encontro el plato");
        }
        return new PlatoResponseDto(Long.toString(plato.get().getCantidadDeCalorias()));
    }

    @Override
    public ListaDeIngredientesDto getIngredients(PlatoRequestDto requestDto){
        Optional<Plato> plato = platoRepository.getByName(requestDto.getName());
        if(!plato.isPresent()){
            throw new DishNotFoundException("No se encontro el plato");
        }
        ObjectMapper mapper = new ObjectMapper();
        ListaDeIngredientesDto ingredientListDto = new ListaDeIngredientesDto(plato.get().getIngredientes().stream().map(p -> mapper.convertValue(p, IngredienteDto.class)).toList());
        return ingredientListDto;
    }

    @Override
    public IngredienteDto getIngredienteConMasCalorias(PlatoRequestDto requestDto){
        Optional<Plato> plato = platoRepository.getByName(requestDto.getName());
        if(!plato.isPresent()){
            throw new DishNotFoundException("No se encontro el plato");
        }
        Optional<Ingrediente> ingrediente = plato.get().getIngredienteMasCalorias();
        return ingrediente.isPresent() ?
                new IngredienteDto(ingrediente.get().getName(), Long.toString(ingrediente.get().getCalories())) :
                new IngredienteDto("","");
    }
}
