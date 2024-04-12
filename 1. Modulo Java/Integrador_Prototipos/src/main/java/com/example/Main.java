package com.example;

public class Main {
    public static void main(String[] args) {
        Prototipo<Integer> serieEntera = new IntSerie(1, 5);
        System.out.println("serie: " + serieEntera.obtenerSiguiente());
    }
}