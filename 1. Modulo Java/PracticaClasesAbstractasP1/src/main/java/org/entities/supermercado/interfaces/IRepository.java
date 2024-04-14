package org.entities.supermercado.interfaces;

import java.util.List;

public interface IRepository<T> {
    void guardar(T entity);
    T recuperar(String id);
    List<T> recuperarTodos();
    void eliminar(String id);
}
