package org.example.repository;

import java.util.Optional;
import java.util.Set;

public interface ICRUDRepository<T> {
    public boolean save(T object);
    public boolean delete(T object);
    public Optional<T> findById(Long id);
    public void imprimirLista();
    public Set<T> findAll();
}
