package meli.bootcamp;

import java.util.Arrays;
import java.util.List;

public class Distribuidora {

  public static void main(String[] args) {
    List<Producto> productos = Arrays.asList(
        new Perecedero("Salchicha", 80, 2),
        new NoPerecedero("Arroz", 80, "Grano")
    );

    double precioTotal = 0;

    for(Producto producto : productos) {
      precioTotal += producto.calcularPrecio(2);
    }

    System.out.println("El precio total es: " + precioTotal);
  }
}
