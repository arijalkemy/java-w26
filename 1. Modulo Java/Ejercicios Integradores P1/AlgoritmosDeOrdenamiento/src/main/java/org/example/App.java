package org.example;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};
        OrdenadorDeArray.burbuja(array);
        imprimirArreglo(array);
    }

    public static void imprimirArreglo(int[] array) {
        for (int elemento : array) {
            System.out.print(elemento + " ");
        }
    }
}
