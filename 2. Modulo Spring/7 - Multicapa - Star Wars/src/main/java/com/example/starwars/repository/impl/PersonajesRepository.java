package com.example.starwars.repository.impl;

import com.example.starwars.model.Personaje;
import com.example.starwars.repository.IRepository;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajesRepository implements IRepository {

    List<Personaje> personajes;

    public PersonajesRepository() {

        personajes = new ArrayList<>();
    }

    @Override
    public List<Personaje> getData() {
        return personajes;
    }

    @Override
    public void postData( List<Personaje> values ) {
        this.personajes.addAll( values );
    }

}
