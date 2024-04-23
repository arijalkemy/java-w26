package org.example.repository;

import java.util.List;
import java.util.Optional;

public interface repositoryCRUD <T>{
    public void save (T objeto);
    public void mostrarPantalla();
    public Optional<T> buscar (long id);
    public void eliminar (long id);
    public List<T> traerTodos();

}
