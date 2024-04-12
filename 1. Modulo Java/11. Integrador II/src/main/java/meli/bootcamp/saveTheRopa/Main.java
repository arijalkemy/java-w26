package meli.bootcamp.saveTheRopa;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    GuardaRopa guardaRopa = new GuardaRopa();
    Prenda prenda1 = new Prenda("Campera", "Nike");
    Prenda prenda2 = new Prenda("Pantalon", "Adidas");
    Prenda prenda3 = new Prenda("Remera", "Puma");
    Prenda prenda4 = new Prenda("Zapatillas", "Reebok");
    Prenda prenda5 = new Prenda("Buzo", "Topper");

    guardaRopa.guardarPrendas(List.of(prenda1, prenda2));
    guardaRopa.guardarPrendas(List.of(prenda3, prenda4, prenda5));

    guardaRopa.mostrarPrendas();

    System.out.println("\nDevolviendo prendas 0");
    System.out.println(guardaRopa.devolverPrendas(0));

    System.out.println("\nDevolviendo prendas 1");
    System.out.println(guardaRopa.devolverPrendas(1));
  }
}
