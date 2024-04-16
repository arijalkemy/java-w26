package com.ejercicio.covid19.repositories.interfaces;

import java.util.List;

public interface IRepository<T> {
    public List<T> getAll();
    public T getByName(String name);
}
