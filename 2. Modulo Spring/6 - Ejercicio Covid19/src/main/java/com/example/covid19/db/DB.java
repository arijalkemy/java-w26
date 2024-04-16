package com.example.covid19.db;

import com.example.covid19.clases.Persona;
import com.example.covid19.clases.Sintoma;
import com.example.covid19.dto.PersonaDto;

import java.util.ArrayList;
import java.util.List;

public class DB {
    List<Sintoma> sintomas;
    List<Persona> personas;
    List<PersonaDto> personasDto;

    public DB(){
        this.personasDto = new ArrayList<>();
        cargarBase();
    }

    private void cargarBase(){

        Sintoma fiebre = new Sintoma("1", "Fiebre", 5);
        Sintoma perdidaDeOlfato = new Sintoma("2", "Perdida de olfato", 7);

        this.sintomas = List.of(fiebre, perdidaDeOlfato);

        Persona personaJoven = new Persona("1", "Jose", "Rodriguez", 32);
        Persona personaGrande = new Persona("2", "Carlos", "Miguel", 72);

        this.personas = List.of( personaJoven, personaGrande);

        personasDto.add( new PersonaDto( personaJoven,sintomas ));
        personasDto.add( new PersonaDto( personaGrande,sintomas ));

    }

    public List<Sintoma> getSintomas() {
        return sintomas;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public List<PersonaDto> getPersonasDto() {
        return personasDto;
    }
}
