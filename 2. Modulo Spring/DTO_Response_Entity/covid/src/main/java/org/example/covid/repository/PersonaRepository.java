package org.example.covid.repository;

import org.example.covid.model.Persona;
import org.example.covid.model.Sintoma;

import java.util.ArrayList;
import java.util.List;

public class PersonaRepository {
    private static List<Persona> personas  = new ArrayList<>(){{
        add(new Persona(1,"juan","perez",40,
                new ArrayList<Sintoma>(){{
                    add(new Sintoma(1,"fiebre","leve"));
                }}
            )
        );
        add(new Persona(1,"miguel","godoy",61,
                        new ArrayList<Sintoma>(){{
                            add(new Sintoma(1,"fiebre","alta"));
                        }}
                )
        );
    }};

    public static List<Persona> getPersonas() {
        return personas;
    }

}
