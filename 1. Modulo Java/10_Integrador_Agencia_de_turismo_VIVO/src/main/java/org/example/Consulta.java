package org.example;

import java.util.List;

public class Consulta {

    public static int calcularCantidadLocalizadores(List<LocalizadorTuristico> localizadores) {
        return localizadores.size();
    }

    public static int calcularCantidadReservas(List<LocalizadorTuristico> localizadores) {
        return localizadores.stream().mapToInt(l -> l.getReservas().size()).sum();
    }

}
