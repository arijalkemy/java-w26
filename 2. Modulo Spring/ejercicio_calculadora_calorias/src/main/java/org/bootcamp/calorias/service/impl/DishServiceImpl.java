package org.bootcamp.calorias.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bootcamp.calorias.dto.DishRequestDTO;
import org.bootcamp.calorias.dto.DishResponseDTO;
import org.bootcamp.calorias.dto.IngredientDTO;
import org.bootcamp.calorias.model.Dish;
import org.bootcamp.calorias.model.Ingredient;
import org.bootcamp.calorias.repository.DishRepository;
import org.bootcamp.calorias.service.DishService;
import org.bootcamp.calorias.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private IngredientService ingredientService;


    @Override
    public List<DishResponseDTO> getAll() {
        return dishRepository.findAll().stream()
                .map(dish -> objectMapper.convertValue(dish, DishResponseDTO.class))
                .toList();
    }

    @Override
    public DishResponseDTO getTotalCalories(DishRequestDTO dishRequestDTO) {
        DishResponseDTO dishResponseDTO = new DishResponseDTO();
        Dish dish = dishRepository.findByName((dishRequestDTO.getName()));
        if (dish.getName() == null)
            return dishResponseDTO;

        // Se setean los valores a devolver en la respuesta del servicio
        dishResponseDTO.setName(dish.getName());
        // Se obtiene las calorias totales segun el peso
        dishResponseDTO.setTotalCalories(dish.getIngredients().stream()
                .mapToDouble(
                        dishValue -> ((double) dishRequestDTO.getWeight() / Ingredient.WEIGHT_CALORIES)
                                * dishValue.getCalories())
                .sum());
        // Se obtiene los ingredientes asociados al plato
        dishResponseDTO.setIngredients(dish.getIngredients().stream()
                .map(ingredient -> objectMapper.convertValue(ingredient, IngredientDTO.class))
                .toList());
        // Se obtiene el ingrediente con el mayor de las calorias
        dishResponseDTO.setIngredientHighest(ingredientService.getHighest(dish.getIngredients()));
        return dishResponseDTO;
    }

    @Override
    public DishResponseDTO saveDish(DishRequestDTO dishRequestDTO) {
        return objectMapper.convertValue(
                dishRepository.save(
                        objectMapper.convertValue(dishRequestDTO, Dish.class)), DishResponseDTO.class);
    }

    @Override
    public List<DishResponseDTO> saveDishAll(List<DishRequestDTO> dishRequestDTOList) {
        return dishRepository.saveAll(
                dishRequestDTOList.stream().map(
                        dishRequestDTO -> objectMapper.convertValue(dishRequestDTO, Dish.class)
                ).toList())
                .stream().map(
                        dish -> objectMapper.convertValue(dish, DishResponseDTO.class))
                .toList();
    }
}
