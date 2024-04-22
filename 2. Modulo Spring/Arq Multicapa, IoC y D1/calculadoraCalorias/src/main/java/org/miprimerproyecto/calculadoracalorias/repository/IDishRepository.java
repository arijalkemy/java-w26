package org.miprimerproyecto.calculadoracalorias.repository;

import org.miprimerproyecto.calculadoracalorias.model.Dish;

import java.util.List;

public interface IDishRepository {
    List<Dish> findAll();
}
