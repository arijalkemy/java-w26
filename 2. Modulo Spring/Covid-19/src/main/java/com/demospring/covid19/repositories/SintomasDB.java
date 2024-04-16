package com.demospring.covid19.repositories;

import com.demospring.covid19.models.Sintoma;

import java.util.ArrayList;
import java.util.List;

public class SintomasDB {
    private static List<Sintoma> sintomas = new ArrayList<>();

    static{
        sintomas.add(new Sintoma(1, "Dolor de cabeza", 3));
        sintomas.add(new Sintoma(2, "Fiebre", 4));
        sintomas.add(new Sintoma(3, "Tos seca", 2));
        sintomas.add(new Sintoma(4, "Dolor de garganta", 3));
        sintomas.add(new Sintoma(5, "Fatiga", 2));
        sintomas.add(new Sintoma(6, "Dificultad para respirar", 5));
        sintomas.add(new Sintoma(7, "Dolor muscular", 3));
        sintomas.add(new Sintoma(8, "Náuseas", 2));
        sintomas.add(new Sintoma(9, "Pérdida del gusto", 4));
        sintomas.add(new Sintoma(10, "Pérdida del olfato", 4));
    }

    public static List<Sintoma> getSintomas() {
        return sintomas;
    }
}
