package bootcamp.bendezujonathan;

import java.util.List;


public class Distribuidora {

    public static void main(String[] args) {
        List<Producto> productos = setUpProducts();
        calculate(productos);
    }

    private static List<Producto> setUpProducts() {
        Producto producto = new Producto("Nombre Generico", 1000);

        Producto perecedero = new Perecedero("Nombre perecedero", 1000, 1);

        Producto noPereProducto = new NoPerecedero("Nombre perecedero", 1200, "Tipo genial");

        return List.of(producto, perecedero, noPereProducto);
    }

    private static void calculate(List<Producto> productos) {
        double acum = 0;
        System.out.println("--------------------------------------------- Factura ---------------------------------------------");
        for (Producto producto : productos) {
            acum += producto.calcular(5);
            System.out.println(String.format("%s Cantidad: %d SubTotal: $%.2f ", producto, 5,acum));
        }
        System.out.println(">> Total: $" + acum);
        System.out.println("---------------------------------------------------------------------------------------------------");
    }
}
