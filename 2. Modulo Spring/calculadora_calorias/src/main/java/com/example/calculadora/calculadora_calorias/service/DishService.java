package com.example.calculadora.calculadora_calorias.service;


import com.example.calculadora.calculadora_calorias.entity.Dish;
import com.example.calculadora.calculadora_calorias.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DishService {
    IRepository<Dish> dishIRepository;

    @Autowired

    public DishService(IRepository<Dish> dishIRepository) {
        this.dishIRepository = dishIRepository;
    }

    public Dish postDish(){
        
    }
}
