package spring.calculadoracalorias.repository;

import spring.calculadoracalorias.entity.Dish;

public interface IDishRepository {
    Dish getDishByName(String name, double weight);
}
