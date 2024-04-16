package com.example.covid.service;

import com.example.covid.entity.Persona;
import com.example.covid.dto.Riesgo;
import com.example.covid.entity.Sintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SintomaServiceImpl implements SintomaService{


    private static List<Sintoma> sintomas = Arrays.asList(
            new Sintoma(1,"adaka","Sueño", 10),
            new Sintoma(2,"adslkf12", "Fiebre", 9),
            new Sintoma(3,"lad9783ja", "Tos", 2),
            new Sintoma(4,"posauie71", "Gripe", 5)
    );

    private static List<Persona> personas = Arrays.asList(
            new Persona(1,"Isay", "Balderas", 18, new ArrayList<>(Arrays.asList(1,4))),
            new Persona(2,"Emi", "Balderas", 19, new ArrayList<>(Arrays.asList(2))),
            new Persona(3,"Cesar", "Martinez", 20, new ArrayList<>()),
            new Persona(4,"Pepe", "Ruiz", 70, new ArrayList<>(Arrays.asList(1,2,3,4)))
    );

    @Override
    public List<Sintoma> todosLosSintomas() {
        return sintomas;
    }

    @Override
    public Sintoma existeSintoma(String nombre) {
        for(Sintoma sintoma: sintomas){
            if(sintoma.getNombre().equalsIgnoreCase(nombre))
                return sintoma;
        }
        return null;
    }

    @Override
    public List<Riesgo> personasRiesgo() {
        List<Riesgo> resultado = new ArrayList<>();
        for(Persona persona:personas){
            if(persona.getEdad() > 60 && persona.getSintomas().size() >= 1)
                resultado.add(new Riesgo(persona.getNombre(), persona.getApellido()));
        }
        return resultado;
    }
}
