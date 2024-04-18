package com.example.calculadora_calorias.service.FoodService.impl;

import com.example.calculadora_calorias.dto.IngredientDto;
import com.example.calculadora_calorias.dto.PlatoRequestDto;
import com.example.calculadora_calorias.dto.PlatoResponseDto;
import com.example.calculadora_calorias.entity.Ingrediente;
import com.example.calculadora_calorias.repository.FoodRepository.IFoodRepository;
import com.example.calculadora_calorias.service.FoodService.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements IFoodService {

    @Autowired
    IFoodRepository foodRepository;

    @Override
    public PlatoResponseDto findDishCalories(PlatoRequestDto platoRequestDto) {
        return getPlatoResponseDto(platoRequestDto);
    }

    @Override
    public List<PlatoResponseDto> findDishListCalories(List<PlatoRequestDto> platoRequestDto) {
        List<PlatoResponseDto> platoResponseDtos;
        platoResponseDtos = platoRequestDto.stream().map(this::getPlatoResponseDto).toList();
        return platoResponseDtos;
    }

    private PlatoResponseDto getPlatoResponseDto(PlatoRequestDto d) {
        PlatoResponseDto platoResponseDto = new PlatoResponseDto();
        platoResponseDto.setName(d.getName());
        platoResponseDto.setIngredients(d.getIngredientes());
        platoResponseDto.setTotalCalorias(platoResponseDto.getIngredients().stream().mapToInt(this::calcularCalorias).sum());
        platoResponseDto.setMostCaloricIngredient(platoResponseDto.getIngredients().stream().max(Comparator.comparingInt(this::calcularCalorias)).orElse(null));
        return  platoResponseDto;
    }

    private Integer calcularCalorias(IngredientDto ingredient) {
        ingredient.setCalories(0);
        Optional<Ingrediente> ingredientRepo = foodRepository.findByName(ingredient.getName());
        if (ingredientRepo.isPresent() && ingredient.getWeight() != null)
            return (int) (ingredient.getWeight() * ingredientRepo.get().getCalories() / 100.f);
        return 0;
    }

}
