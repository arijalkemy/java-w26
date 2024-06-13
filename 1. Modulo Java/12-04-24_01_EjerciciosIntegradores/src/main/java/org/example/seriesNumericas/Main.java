package org.example.seriesNumericas;

public class Main {
    public static void main(String[] args) {
        SerieDeDos serieDeDos = new SerieDeDos();
        System.out.println("Serie de Dos:");
        System.out.println(serieDeDos.valorSiguiente()); // 2
        System.out.println(serieDeDos.valorSiguiente()); // 4
        System.out.println(serieDeDos.valorSiguiente()); // 6

        serieDeDos.establecerValorInicial(1);
        System.out.println("Serie de Dos con valor inicial 1:");
        System.out.println(serieDeDos.valorSiguiente()); // 3
        System.out.println(serieDeDos.valorSiguiente()); // 5

        SerieDeTres serieDeTres = new SerieDeTres();
        System.out.println("Serie de Tres:");
        System.out.println(serieDeTres.valorSiguiente()); // 3
        System.out.println(serieDeTres.valorSiguiente()); // 6
        System.out.println(serieDeTres.valorSiguiente()); // 9
    }
}
