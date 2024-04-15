package org.example.repositorio;

import java.util.List;
import java.util.Optional;

public interface IRepositorioCRUD <T>{
    public void guardar(T element);
    public Optional<T> encontrar(Long id);
    public List<T> encontrarTodos();
    public void borrar(Long id);
    public void imprimir();
}
