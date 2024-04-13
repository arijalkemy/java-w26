package org.example.classes;

import java.util.List;

public class SerieInteger extends Prototipo<Integer> {

    public SerieInteger(List<Integer> serie, Integer salto) {
        super(serie, salto);
    }

    public Integer obtenerSiguiente() {
        Integer ultimoValor = serie.get(serie.size()-1);
        Integer siguienteValor = ultimoValor + salto;
        serie.add(siguienteValor);
        System.out.println(serie.size() + "° vez: " + siguienteValor);
        return siguienteValor;
    }
}
