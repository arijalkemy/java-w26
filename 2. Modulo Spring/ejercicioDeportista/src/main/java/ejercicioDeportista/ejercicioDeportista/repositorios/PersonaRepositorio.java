package ejercicioDeportista.ejercicioDeportista.repositorios;

import ejercicioDeportista.ejercicioDeportista.entidades.Deporte;
import ejercicioDeportista.ejercicioDeportista.entidades.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaRepositorio {
    List<Persona> personas;

    public PersonaRepositorio(List<Persona> personas) {
        this.personas = personas;
    }


    public List<Persona> obtenerPersonas(){
        return this.personas;
    }
}
