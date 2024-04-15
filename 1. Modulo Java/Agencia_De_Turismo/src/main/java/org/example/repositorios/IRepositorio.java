package org.example.repositorios;

import java.util.List;
import java.util.Optional;

public interface IRepositorio <T>{
    public void agregar(T elem);
    public Optional <T> encontrar(Integer id);
    public List<T> encontrarTodos();
}
