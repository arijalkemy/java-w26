package com.calculadora.calorias.Service.Interface;

import com.calculadora.calorias.Dto.IngredienteDto;
import com.calculadora.calorias.Dto.ListaDeIngredientesDto;
import com.calculadora.calorias.Dto.PlatoRequestDto;
import com.calculadora.calorias.Dto.PlatoResponseDto;

public interface IPlatoService {

    PlatoResponseDto getCalorias(PlatoRequestDto requestDto);

    ListaDeIngredientesDto getIngredients(PlatoRequestDto requestDto);

    IngredienteDto getIngredienteConMasCalorias(PlatoRequestDto requestDto);
}
