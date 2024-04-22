package org.bootcamp;

public class Main {
    public static void main(String[] args) {
        Serie2 serie2 = new Serie2();
        serie2.valorInicial(1);
        System.out.println(serie2.valorSiguiente());
        System.out.println(serie2.valorSiguiente());
        System.out.println(serie2.valorSiguiente());
        System.out.println(serie2.valorSiguiente());

        serie2.reiniciarSerie();
        serie2.valorInicial(3);
        System.out.println(serie2.valorSiguiente());
        System.out.println(serie2.valorSiguiente());
        System.out.println(serie2.valorSiguiente());

        Serie3 serie3 = new Serie3();
        serie3.valorInicial(4);
        System.out.println(serie3.valorSiguiente());
        System.out.println(serie3.valorSiguiente());
        System.out.println(serie3.valorSiguiente());

        serie3.reiniciarSerie();
        serie3.valorInicial(3);
        System.out.println(serie3.valorSiguiente());
        System.out.println(serie3.valorSiguiente());
        System.out.println(serie3.valorSiguiente());

    }
}