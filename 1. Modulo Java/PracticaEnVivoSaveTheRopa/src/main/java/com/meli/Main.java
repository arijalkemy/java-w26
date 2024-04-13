package com.meli;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase Main es el punto de entrada de la aplicación.
 * Crea instancias de Prenda y GuardarRopa, y demuestra la funcionalidad de la clase GuardarRopa.
 */
public class Main {
    /**
     * El método principal de la aplicación.
     * @param args Los argumentos de la línea de comandos. Esta aplicación no utiliza argumentos de línea de comandos.
     */
    public static void main(String[] args) {

        // Crea una nueva instancia de Prenda llamada "prenda" con marca "Levis", modelo "Jean", y tipo "Jean"
        Prenda prenda = new Prenda("Levis","Jean", "Jean");
        // Crea una nueva instancia de Prenda llamada "prenda1" con marca "Adidas", modelo "Superstar", y tipo "Zapatilla"

        Prenda prenda1 = new Prenda("Adidas","Superstar", "Zapatilla");

        // Crea una nueva instancia de GuardarRopa llamada "guardarRopa"
        GuardarRopa guardarRopa = new GuardarRopa();
        // Llama al método guardarPrendas de la instancia guardarRopa con una lista de las dos instancias de Prenda como argumento
        // Almacena el id devuelto en la variable "id"
        Integer id = guardarRopa.guardarPrendas(List.of(prenda, prenda1));
        // Imprime el id de la ropa almacenada
        System.out.println("ID de la ropa guardada: " + id);

        // Imprime un separador
        System.out.println(" ---- Ropa guardada ---- ");
        // Llama al método mostrarPrendas de la instancia guardarRopa
        guardarRopa.mostrarPrendas();

        // Llama al método devolverPrendas de la instancia guardarRopa con el id como argumento
        // Almacena la lista de instancias de Prenda devueltas en la variable "prendas"
        List<Prenda> prendas = guardarRopa.devolverPrendas(id);
        // Imprime un separador
        System.out.println(" ---- Ropa devuelta ----");
        // Imprime cada instancia de Prenda en la lista "prendas"
        prendas.forEach(System.out::println);

        // Imprime un separador
        System.out.println(" --- Ropa restante --- ");
        // Llama al método mostrarPrendas de la instancia guardarRopa
        guardarRopa.mostrarPrendas();
    }
}