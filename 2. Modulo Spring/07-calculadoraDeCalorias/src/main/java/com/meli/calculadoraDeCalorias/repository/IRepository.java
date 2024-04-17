package com.meli.calculadoraDeCalorias.repository;

import java.io.IOException;
import java.util.List;

public interface IRepository<T> {
    List<T> getAll();
    T getByName(String name);
}
