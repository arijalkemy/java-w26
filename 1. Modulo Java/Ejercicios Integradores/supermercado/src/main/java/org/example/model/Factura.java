package org.example.model;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Producto> productos;
    private Double totalCompra;

    public Factura() {}

    public Factura(Cliente cliente, List<Producto> productos) {
        this.cliente = cliente;
        setProductos(productos);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
        setTotalCompra(productos.stream().mapToDouble(x -> x.getCostoUnitario()*x.getCantidad()).sum());
    }

    public  void agregarProducto(Producto producto) {
        productos.add(producto);
        totalCompra+=(producto.getCostoUnitario()*producto.getCantidad());
    }

    public Double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }

    @Override
    public String toString() {
        return "Factura:  " + "\n" +
                  cliente + "\n" +
                "  Productos :  "+"\n" +
                productos+  "\n" +
                "  Total Compra: " + totalCompra + "\n";

    }
}
