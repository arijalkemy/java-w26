import java.util.List;
import java.util.Scanner;

public class Distribuidora {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Producto> productos = List.of(
                new Perecedero(1, "Leche", 10),
                new Perecedero(2, "Pan", 5),
                new Perecedero(3, "Huevos", 15),
                new NoPerecedero("Lavadora", 1000, "Electrodoméstico"),
                new NoPerecedero("Televisor", 1500, "Electrodoméstico"),
                new NoPerecedero("Computadora", 2000, "Electrodoméstico")
        );

        double total = 0;
        for (Producto producto : productos) {
            System.out.println(producto);
            System.out.println("Ingrese la cantidad de producto: ");
            int cantidad = scanner.nextInt();
            total += producto.calcular(cantidad);
        }

        System.out.println("Total: " + total);

    }
}