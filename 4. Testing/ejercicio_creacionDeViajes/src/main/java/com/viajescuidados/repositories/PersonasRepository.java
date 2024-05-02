package com.viajescuidados.repositories;

import com.viajescuidados.entities.Persona;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Profile(value = "prod")
public class PersonasRepository implements IPersonasRepository {
    private List<Persona> personas = new ArrayList<>();

    @Override
    public void guardar(Persona persona) {
        this.personas.add(persona);
        persona.setId(this.personas.size());
    }

    @Override
    public void modificar(Persona persona) {
        // do nothing
    }

    @Override
    public List<Persona> buscarTodos() {
        return this.personas;
    }

    @Override
    public Optional<Persona> buscarPorId(Integer id) {
        return this.personas.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public void limpiarDatos() {
        personas = new ArrayList<Persona>();
    }
}
