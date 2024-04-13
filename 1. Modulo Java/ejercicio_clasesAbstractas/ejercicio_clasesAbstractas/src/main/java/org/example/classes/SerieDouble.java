package org.example.classes;

import java.util.List;

public class SerieDouble extends Prototipo<Double> {

    public SerieDouble(List<Double> serie, Double salto) {
        super(serie, salto);
    }

    public Double obtenerSiguiente() {
        Double ultimoValor = serie.get(serie.size()-1);
        Double siguienteValor = ultimoValor + salto;
        serie.add(siguienteValor);
        System.out.println(serie.size() - 1 + "° vez: " + siguienteValor);
        return siguienteValor;
    }
}
