package org.example.supermercado.repository;

import org.example.supermercado.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoRepo implements CRUD<Producto>{

    List<Producto> productos;

    public ProductoRepo() {
        productos=new ArrayList<>();
    }

    @Override
    public void create(Producto element) {

    }

    @Override
    public void readAll() {

    }

    @Override
    public Optional busqueda() {
        return Optional.empty();
    }

    @Override
    public void eliminar() {

    }

    @Override
    public List<Cliente> obtenerTodos() {
        return null;
    }
}
