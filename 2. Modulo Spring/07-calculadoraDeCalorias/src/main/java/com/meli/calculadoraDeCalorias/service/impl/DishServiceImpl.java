package com.meli.calculadoraDeCalorias.service.impl;

import com.meli.calculadoraDeCalorias.dto.DishRequestDTO;
import com.meli.calculadoraDeCalorias.dto.DishResponseDTO;
import com.meli.calculadoraDeCalorias.dto.IngredientDTO;
import com.meli.calculadoraDeCalorias.model.Dish;
import com.meli.calculadoraDeCalorias.model.Ingredient;
import com.meli.calculadoraDeCalorias.repository.IRepository;
import com.meli.calculadoraDeCalorias.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class DishServiceImpl implements IDishService {

    @Autowired
    private IRepository<Dish> dishRepository;

    @Override
    public DishResponseDTO getDishInfo(DishRequestDTO dishRequestDTO) {
        DishResponseDTO dishDTO = new DishResponseDTO();
        Dish dish = dishRepository.getByName(dishRequestDTO.getName());

        List<Ingredient> lstIngredient = dish.getIngredientList();
        List<IngredientDTO> lstIngredientDTO = pasarIngredientADTO(lstIngredient);

        dishDTO.setIngredients(lstIngredientDTO);
        dishDTO.setMostCaloric(mostCaloric(lstIngredientDTO));
        dishDTO.setTotalCalories(totalCalories(lstIngredientDTO));

        return dishDTO;
    }

    @Override
    public List<DishResponseDTO> getDishesInfo(List<DishRequestDTO> dishRequestDTOList) {
        List<DishResponseDTO> lstDishResponseDTO = new ArrayList<>();
        List<Dish> lstDish = dishRepository.getAll();

        lstDish.forEach(d -> {
            List<IngredientDTO> lstIngredientDTO = pasarIngredientADTO(d.getIngredientList());
            lstDishResponseDTO.add(new DishResponseDTO(totalCalories(lstIngredientDTO),lstIngredientDTO,mostCaloric(lstIngredientDTO)));
        });


        return lstDishResponseDTO;
    }

    private List<IngredientDTO> pasarIngredientADTO(List<Ingredient> lstIngredient) {
        List<IngredientDTO> lstIngredientDTO = new ArrayList<>();
        lstIngredient.forEach(i -> lstIngredientDTO.add(new IngredientDTO(i.getName(), i.getCalories())));
        return lstIngredientDTO;
    }

    private Integer totalCalories(List<IngredientDTO> lstIngredientDTO) {
        return lstIngredientDTO.stream().mapToInt(IngredientDTO::getCalories).sum();
    }

    private IngredientDTO mostCaloric(List<IngredientDTO> lstIngredientDTO) {
        return lstIngredientDTO.stream()
                .sorted(Comparator.comparing(IngredientDTO::getCalories))
                .findFirst().orElse(null);
    }


}
