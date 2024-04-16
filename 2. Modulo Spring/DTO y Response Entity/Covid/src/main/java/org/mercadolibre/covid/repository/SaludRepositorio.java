package org.mercadolibre.covid.repository;

import org.mercadolibre.covid.entity.Persona;
import org.mercadolibre.covid.dto.PersonaDTO;
import org.mercadolibre.covid.entity.Sintoma;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SaludRepositorio {
    List<Sintoma> listaDeSintomas;
    List<Persona> listaDePersonas;

    public SaludRepositorio() {
        this.listaDeSintomas = List.of(
                new Sintoma(1, "Dolor de cabeza", 3),
                new Sintoma(2, "Dolor de panza", 1),
                new Sintoma(3, "Tos", 1)
        );
        this.listaDePersonas = List.of(
                new Persona(1,"Persona", "Uno", 24, List.of(this.listaDeSintomas.get(0))),
                new Persona(2,"Otra Persona", "Uno", 65, List.of(this.listaDeSintomas.get(1))),
                new Persona(3,"Persona", "Dos", 20),
                new Persona(4,"Otra", "Persona", 59, List.of(this.listaDeSintomas.get(2))),
                new Persona(5,"Ultima", "Persona", 60, List.of(this.listaDeSintomas.get(1)))
        );
    }

    public List<PersonaDTO> getPersonasDeRiesgo(){
        List<PersonaDTO> personasDeRiesgo = new ArrayList<PersonaDTO>();

        for (Persona persona : listaDePersonas){
            if (persona.esDeRiesgo()){
                personasDeRiesgo.add(
                        new PersonaDTO(persona.getNombre(), persona.getApellido())
                );
            }
        }
        return personasDeRiesgo;
    }

    public List<Sintoma> getListaDeSintomas() {
        return listaDeSintomas;
    }

    public Sintoma getSintoma(String nombreSintoma){
        Optional<Sintoma> busquedaSintoma = this.listaDeSintomas.stream().filter( x -> nombreSintoma.equals(x.getNombre() )).findFirst();
        return busquedaSintoma.orElse(null);
    }

    public void setListaDeSintomas(List<Sintoma> listaDeSintomas) {
        this.listaDeSintomas = listaDeSintomas;
    }

    public List<Persona> getListaDePersonas() {
        return listaDePersonas;
    }

    public void setListaDePersonas(List<Persona> listaDePersonas) {
        this.listaDePersonas = listaDePersonas;
    }
}
