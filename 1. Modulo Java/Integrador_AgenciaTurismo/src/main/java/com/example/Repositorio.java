package com.example;

import java.util.List;

public interface Repositorio<T> {
    List<T> findAll();
    void add(T obj);
    T find(int id);
}
