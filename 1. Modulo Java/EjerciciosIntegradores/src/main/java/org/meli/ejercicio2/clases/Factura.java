package org.meli.ejercicio2.clases;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Producto> productos;

    public Factura(Cliente cliente, List<Producto> productos) {
        this.cliente = cliente;
        this.productos = productos;
    }

    public Factura(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public void imprimirFactura() {
        System.out.println(this.cliente.toString()+"\n");
        System.out.println("Productos:\n");
        System.out.println("Código   Nombre   Costo   Cantidad");
        for (Producto producto : productos) {
            System.out.println(producto.toString()+"\n");
        }
    }

}
