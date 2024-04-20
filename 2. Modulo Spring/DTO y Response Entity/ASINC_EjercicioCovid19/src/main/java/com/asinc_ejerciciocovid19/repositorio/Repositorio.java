package com.asinc_ejerciciocovid19.repositorio;

import com.asinc_ejerciciocovid19.entidad.Persona;
import com.asinc_ejerciciocovid19.entidad.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class Repositorio {
    public static List<Sintoma> listaSintomas;
    public static List<Persona> listaPersonas;

    static {

        listaSintomas = new ArrayList<>();
        listaSintomas.add(new Sintoma(1,"Fiebre", "Grave"));
        listaSintomas.add(new Sintoma(2,"Tos", "Moderado"));
        listaSintomas.add(new Sintoma(3,"Mucosidad", "Leve"));

        listaPersonas = new ArrayList<>();
        listaPersonas.add((new Persona(1, "Marcos", "Ditta", 24, List.of(listaSintomas.get(0),
                                                                                            listaSintomas.get(2)))));
        listaPersonas.add((new Persona(2, "Sol", "Diaz", 86, List.of(listaSintomas.get(1)))));
        listaPersonas.add((new Persona(2, "Mayra", "Granthon", 58, null)));
    }
}
