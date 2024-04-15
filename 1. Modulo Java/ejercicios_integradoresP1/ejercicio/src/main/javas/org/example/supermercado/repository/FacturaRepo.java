package org.example.supermercado.repository;

import org.example.supermercado.models.Cliente;
import org.example.supermercado.models.Factura;

import java.util.List;
import java.util.Optional;

public class FacturaRepo implements CRUD<Factura> {


    @Override
    public void create(Factura element) {

    }

    @Override
    public void readAll() {

    }

    @Override
    public Optional<Factura> busqueda() {
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
