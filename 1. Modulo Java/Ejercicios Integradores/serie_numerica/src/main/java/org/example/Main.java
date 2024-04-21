package org.example;

import org.example.model.SerieIncrementoDos;
import org.example.model.SerieIncrementoTres;

public class Main {
    public static void main(String[] args) {
        SerieIncrementoDos serieIncrementoDos = new SerieIncrementoDos();
        SerieIncrementoTres serieIncrementoTres = new SerieIncrementoTres();

        System.out.println("--------------- Serie Incremento 2 ---------------");
        serieIncrementoDos.valorIncial(11);
        System.out.println("Inicia en: "+ serieIncrementoDos.getValorActual());
        System.out.println("    Siguiente: "+ serieIncrementoDos.valorSiguiente());
        System.out.println("    Siguiente: "+ serieIncrementoDos.valorSiguiente());
        System.out.println("    Siguiente: "+ serieIncrementoDos.valorSiguiente());
        System.out.println("    Siguiente: "+ serieIncrementoDos.valorSiguiente());
        System.out.println("    Reiniciando ..... ");
        serieIncrementoDos.valorReiniciar();
        System.out.println("    Valor actual: "+ serieIncrementoDos.getValorActual());
        System.out.println("    Siguiente: "+ serieIncrementoDos.valorSiguiente());
        System.out.println("--------------- Serie Incremento 3 ---------------");
        serieIncrementoTres.valorIncial(1.0);
        System.out.println("Inicia en: "+ serieIncrementoTres.getValorActual());
        System.out.println("    Siguiente: "+ serieIncrementoTres.valorSiguiente());
        System.out.println("    Siguiente: "+ serieIncrementoTres.valorSiguiente());
        System.out.println("    Siguiente: "+ serieIncrementoTres.valorSiguiente());
        System.out.println("    Siguiente: "+ serieIncrementoTres.valorSiguiente());
        System.out.println("    Reiniciando ..... ");
        serieIncrementoTres.valorReiniciar();
        System.out.println("    Valor actual: "+ serieIncrementoTres.getValorActual());
        System.out.println("    Siguiente: "+ serieIncrementoTres.valorSiguiente());
    }
}