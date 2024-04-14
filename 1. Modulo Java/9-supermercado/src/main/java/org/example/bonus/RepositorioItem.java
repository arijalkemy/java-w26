package org.example.bonus;

import org.example.Item;

import java.util.ArrayList;
import java.util.List;

public class RepositorioItem implements ICrud<Item> {

    List<Item> listaItems;

    public RepositorioItem() {
        listaItems = new ArrayList<>();
    }

    @Override
    public void alta(Item item) {
        if (listaItems.stream().filter(f -> f.getCodigo().equalsIgnoreCase(item.getCodigo())).count() > 0) {
            System.out.println("Ya existe un item con el codigo: " + item.getCodigo());
        } else {
            this.listaItems.add(item);
            System.out.println("Se agrego el item: " + item);
        }
    }

    @Override
    public void baja(String id) {
        boolean eliminarOK = listaItems.removeIf(i -> i.getCodigo().equals(id));
        if (eliminarOK) {
            System.out.println("El cliente con el DNI: " + id + " fue eliminado de la lista");
        } else {
            System.out.println("No existe un cliente con ese DNI en la lista actual");
        }
    }

    @Override
    public Item buscar(String id) {
        return listaItems.stream()
                .filter(i -> i.getCodigo().equals(id)).findAny().orElse(null);
    }

    @Override
    public void mostrarLista() {
        listaItems.forEach(System.out::println);
    }

    @Override
    public List<Item> traerTodos() {
        return listaItems;
    }
}
