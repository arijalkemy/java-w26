package com.example.calculadora.calculadora_calorias.repository.impl;

import com.example.calculadora.calculadora_calorias.entity.Dish;
import com.example.calculadora.calculadora_calorias.entity.Ingredient;
import com.example.calculadora.calculadora_calorias.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class IRepositoryDishImpl implements IRepository<Dish> {
    List<Dish> dishList;
    IRepository<Ingredient> ingredientIRepository;

    @Autowired
    public IRepositoryDishImpl(IRepository<Ingredient> ingredientIRepository) {
        this.dishList = dishList;
        this.ingredientIRepository = ingredientIRepository;
    }

    @Override
    public void add(Dish data) {
        dishList.add(data);
    }

    @Override
    public Optional<Dish> getByName(String name) {
       return dishList.stream()
                .filter(e-> e.getName().equals(name))
                .findFirst();
    }

    @Override
    public List<Dish> getAll() {
        return dishList;
    }

    private List<Dish> fillDb(){
        List<Dish> dishes = new ArrayList<>();







        Dish dish1 = new Dish("Milanesa",25,)
    }
}
