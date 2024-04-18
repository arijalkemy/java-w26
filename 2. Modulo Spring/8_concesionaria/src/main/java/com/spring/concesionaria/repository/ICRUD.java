package com.spring.concesionaria.repository;

import java.util.List;

public interface ICRUD<T> {

    void create(T obj);

    T search(Integer id);

    void update(T obj);

    void delete(Number id);

    List<T> getAll();

}
