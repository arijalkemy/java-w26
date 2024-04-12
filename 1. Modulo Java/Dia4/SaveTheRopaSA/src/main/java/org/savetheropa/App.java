package org.savetheropa;

/**
 * Hello world!
 *
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Crear las dos prendas
        Prenda prenda1 = new Prenda("Adidas", "Pantalón");
        Prenda prenda2 = new Prenda("Nike", "Camiseta");
        //Prenda que no debe ser devuelta
        Prenda prenda3 = new Prenda("Rebook", "Camiseta");

        // Crear una lista de prendas
        List<Prenda> prendas = new ArrayList<>();
        prendas.add(prenda1);
        prendas.add(prenda2);

        List<Prenda> prendas2 = new ArrayList<>();
        prendas2.add(prenda3);

        // Crear el guardarropas
        GuardaRopa guardaRopa = new GuardaRopa();

        // Guardar las prendas
        guardaRopa.guardarPrendas(prendas);
        guardaRopa.guardarPrendas(prendas2);

        // Mostrar todas las prendas en el guardarropas
        System.out.println("Prendas en el guardarropas:\n");
        guardaRopa.mostrarPrendas();

        // Consultar por las prendas guardadas bajo el número identificador
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el número identificador de la prenda:");
        int numeroIdentificador = teclado.nextInt();
        List<Prenda> prendasRecuperadas = guardaRopa.devolverPrendas(numeroIdentificador);
        System.out.println("Prendas recuperadas:");
        for (Prenda prenda : prendasRecuperadas) {
            System.out.println("Marca: " + prenda.getMarca() + ", Modelo: " + prenda.getModelo());
        }
    }
}

