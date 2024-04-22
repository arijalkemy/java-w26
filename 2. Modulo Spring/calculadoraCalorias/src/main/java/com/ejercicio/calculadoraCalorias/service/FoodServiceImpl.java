package com.ejercicio.calculadoraCalorias.service;

import com.ejercicio.calculadoraCalorias.model.Dish;
import com.ejercicio.calculadoraCalorias.model.Food;
import com.ejercicio.calculadoraCalorias.repository.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class FoodServiceImpl implements IFoodService{

    @Autowired
    IFoodRepository iFoodRepository;


    @Override
    public List<Dish> getDish(String dishName, double weight) {
        List<Dish> dishList = iFoodRepository.getDishList();
        List<Dish> results = dishList.stream().filter(Dish -> Dish.getName().equals(dishName)).collect(Collectors.toList());
        return results;
    }
}
