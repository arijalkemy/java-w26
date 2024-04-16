package com.example.c2deportistas.service;

import com.example.c2deportistas.domain.Deporte;
import com.example.c2deportistas.domain.Persona;
import com.example.c2deportistas.dto.DeporteDTO;
import com.example.c2deportistas.dto.PersonaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DesportistasServiceImpl implements IDeportistasService{

    static List<Persona> personas;
    static List<Deporte> deportes;
    @Override
    public List<Deporte> consultarDeportes() {

        return traerDeportes();
    }

    @Override
    public Deporte existeDeporte(String nombre) {
        List<Deporte>deportes = traerDeportes();
        for (Deporte actual : deportes) {
            if(nombre.equals(actual.getNombre())){
                return actual;
            }
        }
        return null;
    }

    @Override
    public PersonaDTO consultarPersonaDeportista() {
        PersonaDTO personaDTO = new PersonaDTO()
                .setNombre("erik")
                .setApellido("quispe")
                .setDeporteRealizado(new DeporteDTO("futbol"));
        return personaDTO;
    }

    public List<Deporte> traerDeportes(){
        Persona persona1 = new Persona("erik","quispe",11);
        Deporte futbol = new Deporte("futbol", "11");

        deportes = new ArrayList<>();
        deportes.add(futbol);
        return deportes;
    }
    public List<Persona> traerPersonas(){
        Persona persona1 = new Persona("erik","quispe",11);
        Deporte futbol = new Deporte("futbol", "11");

        personas = new ArrayList<>();
        personas.add(persona1);
        return personas;
    }
}
