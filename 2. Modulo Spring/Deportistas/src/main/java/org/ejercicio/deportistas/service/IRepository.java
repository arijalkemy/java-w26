package org.ejercicio.deportistas.service;

import java.util.List;

public interface IRepository<T> {
    T findByName(String name);
    List<T> findAll();
}
