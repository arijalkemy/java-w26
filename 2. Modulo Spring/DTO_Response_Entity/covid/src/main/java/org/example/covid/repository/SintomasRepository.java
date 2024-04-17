package org.example.covid.repository;

import org.example.covid.model.Sintoma;

import java.util.ArrayList;
import java.util.List;

public class SintomasRepository {
    static public List<Sintoma> getSintomas(){
        return PersonaRepository.getPersonas().stream()
                .flatMap(p -> p.getSintomas().stream()).toList();
    }
}
