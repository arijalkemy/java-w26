package meli.bootcamp.calculadora.service.interfaces;

import meli.bootcamp.calculadora.dto.FoodDto;

import java.util.List;

public interface IFood {
    List<FoodDto> findFood(String ... nomes);
}
