package agencia.productos;

import java.util.Map;

public class Producto {
    private ProductoTypes categoria;
    private Double precio;

    public Double getPrecio() {
        return precio;
    }

    public ProductoTypes getCategoria() {
        return categoria;
    }

    public Producto(Double precio, ProductoTypes categoria) {
        this.precio = precio;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "categoria=" + categoria +
                ", precio=" + precio +
                '}';
    }
}

