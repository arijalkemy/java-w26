import java.util.ArrayList;

public class Distribuidora {
    private ArrayList<Producto> productos;

    public Distribuidora() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void venderProductos(){
        for (Producto producto : productos) {
            System.out.println(producto.calcular(5));
        }
    }
}
