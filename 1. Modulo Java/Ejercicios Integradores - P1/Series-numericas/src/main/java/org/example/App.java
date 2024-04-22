package org.example;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[] args) {
        Prototipo<Integer> serieEntera = new IntSerie(1, 5);
        System.out.println("serie: " + serieEntera.obtenerSiguiente());
    }
}
