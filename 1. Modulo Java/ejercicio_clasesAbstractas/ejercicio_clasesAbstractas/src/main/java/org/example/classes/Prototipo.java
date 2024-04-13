package org.example.classes;

import java.util.ArrayList;
import java.util.List;

public abstract class Prototipo<T extends Number> {

    protected List<T> serie;
    protected T salto;

    public Prototipo(List<T> serie, T salto) {
        this.serie = serie;
        this.salto = salto;
    }

    public T obtenerSiguiente() {
        return null;
    }

    public void reiniciarSerie() {
        serie = new ArrayList<T>();
        System.out.println("Serie reiniciada.");
    }

    public void valorInicial(T inicial) {
        if (serie.size() > 0) {
            System.out.println("Reinicie la serie antes de establecer un valor inicial.");
        } else {
            serie.add(inicial);
            System.out.println("Valor inicial de la serie: " + inicial);
        }
    }
}
