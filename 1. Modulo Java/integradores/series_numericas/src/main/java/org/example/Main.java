package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<SerieNumerica> seriesNumericas = new ArrayList<SerieNumerica>(){{
            add(new SerieInteger(2));
            add(new SerieDouble(2.5));
        }};

        seriesNumericas.forEach(serieNumerica -> {
            System.out.println(serieNumerica.devolverSiguienteValor());
            System.out.println(serieNumerica.devolverSiguienteValor());
            serieNumerica.establecerValorInicial(10);
            System.out.println(serieNumerica.devolverSiguienteValor());
            System.out.println(serieNumerica.devolverSiguienteValor());
            serieNumerica.reiniciarSerie();
            System.out.println(serieNumerica.devolverSiguienteValor());
            System.out.println(serieNumerica.devolverSiguienteValor());
        });

    }
}
