package com.example.calculadora.calculadora_calorias.repository;

import java.util.List;
import java.util.Optional;

public interface IRepository<T> {
    public void add(T data);
    public Optional<T> getByName(String name);
    public List<T> getAll();
}
