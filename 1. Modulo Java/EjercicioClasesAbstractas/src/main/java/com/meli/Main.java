package com.meli;

public class Main {
    public static void main(String[] args) {
        SerieProgresiva2 serieProgresiva2 = new SerieProgresiva2();
        SerieProgresiva3 serieProgresiva3 = new SerieProgresiva3();

        System.out.println("----- Serie prgresiva de 2 -----");
        serieProgresiva2.establecerValorInicial(1);
        System.out.println(serieProgresiva2.valorSiguiente());
        System.out.println(serieProgresiva2.valorSiguiente());
        System.out.println(serieProgresiva2.valorSiguiente());

        System.out.println("----- Serie prgresiva de 3 -----");
        System.out.println(serieProgresiva3.valorSiguiente());
        System.out.println(serieProgresiva3.valorSiguiente());
        System.out.println(serieProgresiva3.valorSiguiente());
        serieProgresiva3.reiniciarSerie();
        System.out.println(serieProgresiva3.valorSiguiente());

    }
}