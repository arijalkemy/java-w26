package org.example.bonus;

import java.util.List;

public interface ICrud<T> {
    void alta(T obj);
    void baja(String id);
    T buscar(String id);
    void mostrarLista();
    List<T> traerTodos();
}
