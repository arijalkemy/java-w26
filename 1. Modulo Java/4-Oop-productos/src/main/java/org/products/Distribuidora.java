package org.products;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    List<Producto> productos = new ArrayList<Producto>();

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    private int obtenerProductoIdxPorNombre(String nombreProducto) {
        int idx = -1;
        for (int i = 0; i < this.productos.size(); i++) {
            if (this.productos.get(i).nombre.equals(nombreProducto)) {
                idx = i;
            }
        }
        return idx;
    }

    public double venderProducto(String nombreProducto) {
        int idx = this.obtenerProductoIdxPorNombre(nombreProducto);
        double precioProducto = this.productos.get(idx).precio;
        this.productos.remove(idx);
        return precioProducto;
    }

    public void calcularPrecioPerecedero(String nombreProducto, int cantidadDeProductos) {
        int idx = this.obtenerProductoIdxPorNombre(nombreProducto);
        this.productos.get(idx).calcular(cantidadDeProductos);
    }
}
