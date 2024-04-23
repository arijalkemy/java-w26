package com.mercadolibre.Covid19API.repository;

import com.mercadolibre.Covid19API.model.Persona;
import com.mercadolibre.Covid19API.model.Sintoma;

import java.util.List;

public class RepoBD {
    public static List<Sintoma> sintomas = List.of(new Sintoma("001", "Tos Seca","leve"),
            new Sintoma("002", "Perdida del gusto y/o olfato","leve"),
            new Sintoma("003", "Fatiga","leve"),
            new Sintoma("004", "Dolores musculares","moderada"),
            new Sintoma("005", "Tos persistente","moderada"),
            new Sintoma("006", "Dificultad para respirar moderada","moderada"),
            new Sintoma("007", "Coloración azulada en labios y/o rostro","Critica"),
            new Sintoma("008", "Dificultad para mantenerse despierto","Critica"),
            new Sintoma("009", "Dificultad para respirar grave","Critica"));

    public static List<Persona> personas = List.of(
            new Persona("1002", "Clara","Perez", 29, (List.of(sintomas.get(0),sintomas.get(1)))),
            new Persona("1002", "Clara","Perez", 29, (List.of(sintomas.get(2),sintomas.get(9)))),
            new Persona("1002", "Clara","Perez", 29, (List.of(sintomas.get(8),sintomas.get(3)))),
            new Persona("1002", "Clara","Perez", 29, (List.of(sintomas.get(4),sintomas.get(7)))),
            new Persona("1002", "Clara","Perez", 29, (List.of(sintomas.get(5),sintomas.get(6)))));
}
