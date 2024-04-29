package org.decodificador.repositorio;

import org.decodificador.modelo.Producto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioProducto {
    private Map<Integer, Producto> map_productos;

    public RepositorioProducto() {
        this.map_productos = new HashMap<>();
        this.asignarListaProductos();
    }
    private void asignarListaProductos() {
        map_productos.put(1, new Producto(1, "Cuaderno escolar", 5000));
        map_productos.put(2, new Producto(2, "Lapiz", 1000));
        map_productos.put(3, new Producto(3, "Borrador", 500));
        map_productos.put(4, new Producto(4, "Regla", 15000));
        map_productos.put(5, new Producto(5, "Calculadora", 105000));
        map_productos.put(6, new Producto(6, "Libreta", 9000));
        map_productos.put(7, new Producto(7, "Estuche", 6000));
        map_productos.put(8, new Producto(8, "Tijeras", 3000));
        map_productos.put(9, new Producto(9, "Cinta adhesiva", 500));
        map_productos.put(10, new Producto(10, "Goma de pan", 500));
    }

    public Producto getProducto(int codigo) {
        return map_productos.get(codigo);
    }
}
