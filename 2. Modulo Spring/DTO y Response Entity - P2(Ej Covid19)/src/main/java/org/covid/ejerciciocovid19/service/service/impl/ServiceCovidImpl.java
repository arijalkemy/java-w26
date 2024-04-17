package org.covid.ejerciciocovid19.service.service.impl;

import org.covid.ejerciciocovid19.model.Persona;
import org.covid.ejerciciocovid19.model.PersonaSintomaDTO;
import org.covid.ejerciciocovid19.model.Sintoma;
import org.covid.ejerciciocovid19.service.IServiceCovid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceCovidImpl implements IServiceCovid {
    List<Sintoma> sintomas = new ArrayList<>();

    Sintoma sintoma1 = new Sintoma("S01", "Fiebre", 1);
    Sintoma sintoma2 = new Sintoma("S02", "dolor de garganta", 2);
    Sintoma sintoma3 = new Sintoma("S03", "Dolor de cabeza", 3);

    Persona persona1 = new Persona(1L, "Juan", "pepe", 23,null);
    Persona persona2 = new Persona(2L, "Maria", "koka", 12,null);
    Persona persona3 = new Persona(3L, "Pedro", "perez", 65,null);
    Persona persona4 = new Persona(4L, "Pachu", "Ez", 65,List.of(sintoma1, sintoma2));


    public void agregarSintomas() {
        sintomas.add(sintoma1);
        sintomas.add(sintoma2);
        sintomas.add(sintoma3);
    }

    List<Persona> personas = List.of(persona1, persona2, persona3, persona4);

    @Override
    public List<Sintoma> findSintomas() {
        agregarSintomas();
        return sintomas;
    }

    @Override
    public int findSintomaByName(String name) {
        agregarSintomas();
        for (Sintoma sintoma : sintomas) {
            if (sintoma.getNombre().equals(name)) {
                return sintoma.getNivelDeGravedad();
            }
        }

        return 0;
    }
    @Override
    public List<PersonaSintomaDTO> findRiskPersons() {
        List<PersonaSintomaDTO> personasDeRiesgo = new ArrayList<>();

        for (Persona persona : personas) {
            if (persona.getEdad() > 60  && persona.getSintomas().size() > 0) {
                personasDeRiesgo.add(new PersonaSintomaDTO(persona.getNombre(), persona.getApellido()));
            }
            return personasDeRiesgo;
        }
        return null;
    }


}
