package org.example.ejerciciocalculadoracalorias.repository;

import org.example.ejerciciocalculadoracalorias.entity.Dish;

import java.util.List;

public interface IMenuRepository {

    public Dish findOne(String name);

    public List<Dish> findAll();
}
