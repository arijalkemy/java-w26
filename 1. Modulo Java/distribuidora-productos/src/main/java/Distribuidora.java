import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    private List<Producto> productos;

    public Distribuidora() {
        this.productos = new ArrayList<>();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void agregarProducto(Producto ... producto ){
       for (Producto p : producto){
           this.productos.add(p);
       }
    }
    public double calcularPrecioTotal(int cantidad) {
        double precioTotal = 0;
        for (Producto p : productos) {
            precioTotal += p.calcular(cantidad);
        }
        return precioTotal;
    }
}
