package org.example.calorias.repository;

import org.example.calorias.entity.Plato;

import java.util.List;
import java.util.Optional;

public interface IPlatoRepository {
    List<Plato> buscarTodos();
    Optional<Plato> buscarPorNombre(String nombre);
}
