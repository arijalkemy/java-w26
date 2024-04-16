package org.example.repository;

import org.example.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository <T> {

    public void save (Cliente object);
    public void mostrarPantalla();
    public Optional<T> buscar (Long id);
    public void elminar (Long id);
}
