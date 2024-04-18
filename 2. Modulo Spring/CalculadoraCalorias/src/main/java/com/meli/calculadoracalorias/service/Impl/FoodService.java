package com.meli.calculadoracalorias.service.Impl;

import com.meli.calculadoracalorias.dto.FoodDTO;
import com.meli.calculadoracalorias.repository.GetData;
import com.meli.calculadoracalorias.service.IFood;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService implements IFood {

    @Override
    public FoodDTO food(String name) {
        GetData getData = new GetData();
        return getData.createFoods().stream().filter(food -> food.getName().equals(name));
    }

    @Override
    public List<FoodDTO> foodList() {
        return List.of();
    }
}
