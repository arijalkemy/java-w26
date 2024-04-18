package com.ejercicio.calculadoradecalorias.repository.interfaces;

import com.ejercicio.calculadoradecalorias.entity.Ingredient;
import java.util.List;

public interface IRepository<T> {
    public List<T> getAll();
    public T getByName(String name);
}
