package com.meli.calculadoracalorias_vivo.repository;

import com.meli.calculadoracalorias_vivo.entity.Dish;

import java.util.List;

public interface IMenuRepository {

    public Dish findOne(String name);

    public List<Dish> findAll();
}
