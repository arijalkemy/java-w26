package org.miprimerproyecto.calculadoracalorias.service;

import org.miprimerproyecto.calculadoracalorias.dto.DishDTO;
import org.miprimerproyecto.calculadoracalorias.model.Dish;
import org.miprimerproyecto.calculadoracalorias.model.Ingredient;
import org.miprimerproyecto.calculadoracalorias.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService implements IDishService {

    @Autowired
    DishRepository dishRepository;


    @Override
    public String getDish(String name, int weigth) {
        //Se extrae el plato y se hace el calculo de la cantidad de calorias
        DishDTO dishDTO=new DishDTO();
        Dish aux= dishRepository.findAll().stream().filter(x-> x.getName().equals(name)).findFirst().get();
        dishDTO.setName(aux.getName());
        dishDTO.setIngredients(aux.getIngredientList());
        int total=0;
        for(Ingredient element: aux.getIngredientList()){
            total+= element.getCalories()*weigth;
        }
        dishDTO.setWeigthTotal(total);
        return dishDTO.toString();
    }
}
