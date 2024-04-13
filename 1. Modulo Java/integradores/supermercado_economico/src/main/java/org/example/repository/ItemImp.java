package org.example.repository;

import org.example.models.Item;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ItemImp implements ICRUDRepository<Item> {

    Set<Item> items = new HashSet<>();

    @Override
    public boolean save(Item i) {
        return items.add(i);
    }

    @Override
    public boolean delete(Item i) {
        return items.remove(i);
    }

    @Override
    public Optional<Item> findById(Long codigo) {
        return items.stream()
                .filter(i -> i.getCodigo().equals(codigo))
                .findFirst();
    }

    @Override
    public void imprimirLista() {
        System.out.println("Lista de Items: ");
        items.forEach(System.out::println);
    }

    @Override
    public Set<Item> findAll() {
        return items;
    }
}
