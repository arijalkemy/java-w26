package org.example;

import java.util.List;
import java.util.Map;

public class Consulta {

    public static int calcularCantidadLocalizadores(List<LocalizadorTuristico> localizadores){
        return localizadores.size();
    }

    public static long calcularCantidadReservas(List<LocalizadorTuristico> localizadores){
        return localizadores.stream().mapToLong(l -> l.getReservas().size()).sum();
    }

}
