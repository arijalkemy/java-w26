package com.ejercicio.deportistas.repository.interfaces;

import java.util.List;

public interface IRepository<T> {
    public List<T> getAll();
    public T getByName(String name);
}
