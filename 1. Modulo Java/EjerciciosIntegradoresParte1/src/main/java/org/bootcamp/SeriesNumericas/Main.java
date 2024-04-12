package org.bootcamp.SeriesNumericas;

public class Main {
    public static void main(String[] args) {
        SerieProgresivaEntero serieEntero = new SerieProgresivaEntero(2);
        serieEntero.establecerInicial(2);
        for (int i = 0; i < 5; i++) {
            System.out.println("siguiente valor, serie entera: " + serieEntero.siguienteValor());
        }

        System.out.println("Serie reiniciada");
        serieEntero.reiniciar();
        for (int i = 0; i < 4; i++) {
            System.out.println("siguiente valor en la serie entera: " + serieEntero.siguienteValor());
        }

        System.out.println("/////////////////////");
        SerieProgresivaDecimal serieDecimal = new SerieProgresivaDecimal(3.0);
        for (int i = 0; i < 4; i++) {
            System.out.println("siguiente valor en la serie decimal: " + serieDecimal.siguienteValor());
        }

        System.out.println("Serie reiniciada");
        serieDecimal.reiniciar(); // Reiniciar serie
        for (int i = 0; i < 8; i++) {
            System.out.println("siguiente valor en la serie decimal: " + serieDecimal.siguienteValor());
        }
    }
}
