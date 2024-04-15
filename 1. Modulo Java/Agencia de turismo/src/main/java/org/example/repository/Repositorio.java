package org.example.repository;

import java.util.List;
import java.util.Optional;

public interface Repositorio<T, K> {
    void add(T item);
    List<T> findAll();
    Optional<T> findById(K id);
    Boolean existsById(K id);
}
