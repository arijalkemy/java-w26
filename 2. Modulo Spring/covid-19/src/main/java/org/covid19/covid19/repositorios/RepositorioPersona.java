package org.covid19.covid19.repositorios;

import lombok.AllArgsConstructor;
import org.covid19.covid19.entidades.Persona;

import java.util.List;

@AllArgsConstructor
public class RepositorioPersona {

    private List<Persona> personas;

    public List<Persona> obtenerPersonas() {
        return this.personas;
    }

}
