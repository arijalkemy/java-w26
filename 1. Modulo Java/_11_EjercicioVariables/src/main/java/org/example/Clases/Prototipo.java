package org.example.Clases;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public abstract class Prototipo {
    public int numeroSiguienteDeLaSerie(int[] serieProgresiva){
        return 0;
    }
    public int reiniciarLaSerie(int[] serieProgresiva) {
        return 0;
    }
    public List<Integer> numeroInicialDeLaSerie(int numero){
        List<Integer> serie = new ArrayList<>();
        serie.add(numero);
        return serie;
    }

}
