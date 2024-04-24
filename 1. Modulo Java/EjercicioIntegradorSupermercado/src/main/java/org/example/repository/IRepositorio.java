package org.example.repository;

import java.util.List;
import java.util.Optional;

public interface IRepositorio <T>{
    public void guaradar(T objeto);
    public void mostrar();
    public Optional<T> buscar(int id);
    public void eliminar();
}
