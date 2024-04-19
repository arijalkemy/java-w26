package com.meli.concesionaria.repository;

import java.util.List;
import java.util.Optional;

public interface IRepository <T>{
    public Optional<T> getById(Integer id);
    public List<T> getAll();
    public T add(T data);
}
