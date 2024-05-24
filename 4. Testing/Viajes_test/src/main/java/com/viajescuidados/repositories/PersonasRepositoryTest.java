package com.viajescuidados.repositories;

import com.viajescuidados.entities.Persona;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Profile(value = "test")
public class PersonasRepositoryTest implements IPersonasRepository {
    private List<Persona> personas;

    public PersonasRepositoryTest() {
        this.personas = new ArrayList<>();
        this.guardar(new Persona(null, "Mara", "Lopez"));
        this.guardar(new Persona(null, "Juan", "Lopez"));
        this.guardar(new Persona(null, "Ricardo", "Lopez"));
    }

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
}
