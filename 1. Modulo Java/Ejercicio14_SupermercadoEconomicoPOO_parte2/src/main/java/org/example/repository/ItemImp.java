package org.example.repository;

import org.example.model.Item;

import java.util.List;
import java.util.Optional;

public class ItemImp implements repositoryCRUD<Item> {
    @Override
    public void save(Item objeto) {

    }

    @Override
    public void mostrarPantalla() {

    }

    @Override
    public Optional<Item> buscar(long id) {
        return Optional.empty();
    }

    @Override
    public void eliminar(long id) {

    }

    @Override
    public List<Item> traerTodos() {
        return null;
    }
}
