package org.bootcamp;

import org.bootcamp.series.impl.SerieNumerica;

/**
 * @author jsanchezpimi
 */
public class App 
{
    public static void main(String[] args) {
        // Se instancia dos series
        SerieNumerica serieDeDos = new SerieNumerica(0,2);
        SerieNumerica serieDeTres = new SerieNumerica(1, 3);

        // Se imprime la primera serie de dos
        System.out.println("\n*** Primera Serie ***");
        serieDeDos.imprimirSerie(10);

        // Se reinicia la serie
        serieDeDos.reiniciarSerie();
        // Se establece el valor inicial de la serie
        serieDeDos.establecerValorInicial(4);

        //Se vuelve a imprimir la primera serie con los nuevos valores
        System.out.println("\n*** Primera Serie Con Valor Inicial ***");
        serieDeDos.imprimirSerie(10);

        // Se imprime la serie de tres
        System.out.println("\n*** Segunda Serie ***");
        serieDeTres.imprimirSerie(12);

    }
}
