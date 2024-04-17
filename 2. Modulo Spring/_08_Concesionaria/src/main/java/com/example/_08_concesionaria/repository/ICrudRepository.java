package com.example._08_concesionaria.repository;

import java.util.List;

public interface ICrudRepository<T> {
    boolean add(T entity);
    List<T> get();
}
