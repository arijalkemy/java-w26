package com.example.covid.servicios.impl;

import com.example.covid.modelo.Persona;
import com.example.covid.modelo.Sintoma;
import com.example.covid.servicios.IPersonasService;
import com.example.covid.servicios.ISintomasService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonasServiceImpl implements IPersonasService {

    List<Persona> personas = new ArrayList<>();


    private ISintomasService sintomasService;


    public PersonasServiceImpl(ISintomasService sintomasService){

        this.sintomasService = sintomasService;

        Sintoma fiebre = sintomasService.obtenerSintomaDadoElNombre("Fiebre").get();
        Sintoma dolorDeCabeza = sintomasService.obtenerSintomaDadoElNombre("Dolor de cabeza").get();
        Sintoma tos = sintomasService.obtenerSintomaDadoElNombre("Tos").get();

        Persona persona = new Persona(1,"n1","a1", 22, null);
        Persona persona1 = new Persona(2,"n2","a2",65, List.of(tos));
        Persona persona2 = new Persona(3, "n3", "a3", 70, List.of(dolorDeCabeza,fiebre));

        personas.addAll(List.of(persona1,persona,persona2));
    }


    @Override
    public List<Persona> personasDeRiesgo() {
        final int EDAD_RIESGO = 60;
        List<Persona> personasDeRiesgo = personas.stream().filter(p -> p.getEdad()>EDAD_RIESGO).toList();

        return personasDeRiesgo;
    }
}
