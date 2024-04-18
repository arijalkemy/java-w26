package com.ejercicio.calculadoradecalorias.service.implementations;

import com.ejercicio.calculadoradecalorias.DTO.FoodResponseDTO;
import com.ejercicio.calculadoradecalorias.entity.Food;
import com.ejercicio.calculadoradecalorias.exceptions.NotFoundException;
import com.ejercicio.calculadoradecalorias.repository.implementations.FoodRepository;
import com.ejercicio.calculadoradecalorias.service.interfaces.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService implements IFoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public FoodResponseDTO createResponse(String foodName, int weight) {
        Food result = foodRepository.getByName(foodName);
        if (result == null) throw new NotFoundException("No se encontró una comida con el nombre ingresado");

        result.getFoodIngredients()
                .forEach(foodIngredient -> {
                    double newWeight = foodIngredient.getProportionalWeight(result.getTotalWeight(), weight);
                    foodIngredient.setWeight(newWeight);
                });

        return new FoodResponseDTO(
                result.getTotalCalories(),
                result.getFoodIngredients()
        );
    }
}
