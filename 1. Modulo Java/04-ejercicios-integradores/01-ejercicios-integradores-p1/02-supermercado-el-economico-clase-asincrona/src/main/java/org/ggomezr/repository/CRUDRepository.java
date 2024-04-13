package org.ggomezr.repository;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository<T> {
    void save(T objeto);
    void mostrarPorPantalla();
    void buscar(Long dni);
    void eliminar(Long dni);
    List<T> traerTodos();

    void mostrarObjeto(Optional<T> objeto);
}
