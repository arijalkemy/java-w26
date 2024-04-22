package org.bootcamp;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class Factura{
    private Cliente cliente;
    private List<Producto> productos;
    private double total;

    public Factura(Cliente cliente, List<Producto> productos) {
        this.cliente = cliente;
        this.productos = productos;
        this.total = productos.stream().mapToDouble(producto -> producto.getPrecio() * producto.getCantidad()).sum();
    }
}
