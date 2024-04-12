package org.example.Interfaces;

import java.util.List;
import java.util.Optional;

public interface ICrud<T, ID>{
    Optional<T> findById(ID id);

    List<T> findAll();

    T save(T entity);

    T update(T entity);

    void delete(T entity);
}
