package productosPerecederos;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();

        Producto productoNormal = new Producto("arroz", 100);
        productos.add(productoNormal);

        Producto productoPerecedero = new Perecedero("choclo", 200, 2);
        productos.add(productoPerecedero);

        Producto productoNoPerecedero = new NoPerecedero("sal", 300,"almacen");
        productos.add(productoNoPerecedero);

        double costo = 0;

        for (Producto producto : productos){
            System.out.println(producto.toString());
            costo += producto.calcular(5);
        }

        System.out.println(costo);
    }
}
