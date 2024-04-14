package org.example.Collections;
import org.example.Model.Item;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemCollection implements Actions {

    ArrayList<Item> productos;

    public ArrayList<Item> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Item> productos) {
        this.productos = productos;
    }

    public ItemCollection(Item ...productos) {
            this.productos = new ArrayList<>(Arrays.asList(productos));
        }
    @Override
    public void guardar(Object cliente) {
        this.productos.add((Item) cliente);
    }

    @Override
    public void mostrar() {
        for (Item cliente : this.productos) {
            System.out.println(cliente);
        }
    }

    @Override
    public Object buscar(String codigo) {
        return this.productos.stream().filter(i-> i.getCodigo().equals(codigo)).findFirst().orElse(null);
    }

    @Override
    public void eliminar(String codigo) {
        Item deletedItem = (Item) this.buscar(codigo);
        boolean removed = this.productos.removeIf( p -> p.getCodigo().equals(codigo));

        if (removed){
            System.out.println("El Item " + deletedItem.getNombre() + " con codigo: " + deletedItem.getCodigo() + " Fue eliminado");
        }
    }

    @Override
    public String toString() {
        return "ItemCollection{" +
                "productos=" + productos +
                '}';
    }
}

