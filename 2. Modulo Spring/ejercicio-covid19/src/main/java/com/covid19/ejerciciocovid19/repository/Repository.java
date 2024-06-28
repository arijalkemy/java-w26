package com.covid19.ejerciciocovid19.repository;

import com.covid19.ejerciciocovid19.dto.PersonaDto;
import com.covid19.ejerciciocovid19.model.Persona;
import com.covid19.ejerciciocovid19.model.Sintoma;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Repository {

    private List<Persona> listaPersonas =  new ArrayList<>();
    private List<Sintoma> listaSintomas = new ArrayList<>();

    public Repository() {

        Sintoma fiebre = new Sintoma(1, "fiebre", 8);
        Sintoma tos = new Sintoma(2, "tos", 7);
        Sintoma perdidaGusto = new Sintoma(3, "perdida gusto", 10);


        this.listaPersonas.add(new Persona(1, "Maria", "Arias", 20,List.of(tos,fiebre)));
        this.listaPersonas.add(new Persona(2, "Marta", "Lopez", 63, List.of(tos)));
        this.listaPersonas.add(new Persona(3, "Miguel", "Tamayo", 25, List.of(perdidaGusto)));
        this.listaPersonas.add(new Persona(4, "Mario", "Flores", 68, List.of(fiebre)));

        this.listaSintomas.add(fiebre);
        this.listaSintomas.add(tos);
        this.listaSintomas.add(perdidaGusto);
    }

    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public List<Sintoma> getListaSintomas() {
        return listaSintomas;
    }


    public Sintoma getSintoma(String name){
        return listaSintomas.stream().filter(e-> e.getNombre().equals(name)).findAny().orElse(null);
    }

    public List<PersonaDto> getPersonaSintomas(){
        return listaPersonas.stream()
                .filter(e-> e.getEdad()>60)
                .filter(e-> !e.getSintomas().isEmpty())
                .map(e -> new PersonaDto(e.getNombre(), e.getApellido()))
                .collect(Collectors.toList());
    }

}
