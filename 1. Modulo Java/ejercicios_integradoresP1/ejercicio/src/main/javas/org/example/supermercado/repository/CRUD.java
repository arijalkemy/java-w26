package org.example.supermercado.repository;

import org.example.supermercado.models.Cliente;

import java.util.List;
import java.util.Optional;

public interface CRUD<T> {
    public void create(T element);
    public void readAll();
    public Optional<T> busqueda();
    public void eliminar ();
    public List<Cliente> obtenerTodos();

}
