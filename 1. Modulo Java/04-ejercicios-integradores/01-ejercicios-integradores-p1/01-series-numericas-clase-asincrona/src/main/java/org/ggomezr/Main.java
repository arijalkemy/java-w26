package org.ggomezr;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n----- Serie de enteros, numero inicial 0, valor incremento 2 -----\n");

        SerieEnteros serieEnteros1 = new SerieEnteros(0, 2);

        for (int i = 0; i < 4; i++) {
            System.out.println("Siguiente valor: " + serieEnteros1.obtenerSiguienteValor());
        }

        System.out.println("\n----- Serie de enteros, numero inicial 1, valor incremento 3 -----\n");

        SerieEnteros serieEnteros2 = new SerieEnteros(0, 3);

        for (int i = 0; i < 4; i++) {
            System.out.println("Siguiente valor: " + serieEnteros2.obtenerSiguienteValor());
        }

        System.out.println("\n----- Serie de dobles, numero inicial 0.5, valor incremento 0.5 -----\n");

        SerieDobles serieDobles1 = new SerieDobles(0.5, 0.5);

        for (int i = 0; i < 4; i++) {
            System.out.println("Siguiente valor: " + serieDobles1.obtenerSiguienteValor());
        }

        System.out.println("\n----- Serie de dobles, numero inicial 1.5, valor incremento 2.5 -----\n");

        SerieDobles serieDobles2 = new SerieDobles(1.5, 2.5);

        for (int i = 0; i < 4; i++) {
            System.out.println("Siguiente valor: " + serieDobles2.obtenerSiguienteValor());
        }
    }
}