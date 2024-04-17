package com.meli.calculadoraDeCalorias.repository;

import java.util.List;

public interface IRepository<T> {
    List<T> findAll();
    T findByName(String name);
}
