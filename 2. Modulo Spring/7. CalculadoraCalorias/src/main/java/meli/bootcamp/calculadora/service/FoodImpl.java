package meli.bootcamp.calculadora.service;

import lombok.RequiredArgsConstructor;
import meli.bootcamp.calculadora.dto.FoodDto;
import meli.bootcamp.calculadora.dto.mapper.Mapper;
import meli.bootcamp.calculadora.repository.FoodRepository;
import meli.bootcamp.calculadora.service.interfaces.IFood;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodImpl implements IFood {

    private final FoodRepository foodRepository;

    @Override
    public List<FoodDto> findFood(String ... names) {
        List<FoodDto> foods = new ArrayList<>();
        for(String name : names){
            foodRepository.findAll()
                    .stream()
                    .filter(f -> f.getName().toLowerCase().contains(name.toLowerCase()))
                    .map(Mapper::toFoodDto).forEach(foods::add);
        }
        return foods;
    }
}
