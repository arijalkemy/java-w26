package org.example.repository;


import org.example.Factura;
import org.example.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImpl implements ICRUDRepository<Item> {
    List<Item> listaDeItems = new ArrayList<>();

    @Override
    public void guardar(Item objeto) {
        listaDeItems.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        for (Item item : listaDeItems) {
            System.out.println(item);
        }
    }

    @Override
    public Optional<Item> buscar(Long codigoBuscado) {
        Optional<Item> itemEncontrado = listaDeItems.stream().
                filter((item) -> codigoBuscado == item.getCodigo())
                .findFirst();
        itemEncontrado.ifPresent(System.out::println);
        return itemEncontrado;
    }

    @Override
    public void eliminar(Long codigoBuscado) {
        Optional<Item> item = buscar(codigoBuscado);
        if (item.isEmpty()) {
            System.out.println("Ese item no existe en nuestra base de datos");
        } else {
            listaDeItems.remove(item.get());
            System.out.println("item borrado exitosamente");
        }
    }

    @Override
    public List<Item> traerTodos() {
        return listaDeItems;
    }
}
