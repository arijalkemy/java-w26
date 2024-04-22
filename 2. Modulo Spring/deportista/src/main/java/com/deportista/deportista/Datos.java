package com.deportista.deportista;

import com.deportista.deportista.entity.Deporte;
import com.deportista.deportista.entity.Persona;

import java.util.ArrayList;
import java.util.List;

public class Datos {

  private List<Deporte> deportes = new ArrayList <>();
  private List<Persona> personas = new ArrayList<>();

    public Datos() {
        Deporte futbol = new Deporte("futbol", "alto");
        this.deportes.add(futbol);
        Deporte natacion = new Deporte("natacion", "medio");
        this.deportes.add(natacion);
        Deporte padel = new Deporte("padel", "bajo");
        this.deportes.add(padel);

        this.personas.add(new Persona("Monica", "Lopez", 32, padel ));
        this.personas.add(new Persona("Daniel", "Aguirre", 35, futbol ));
        this.personas.add(new Persona("Cristina", "Lopez", 31, natacion ));

    }

    public List<Deporte> getDeportes() {
        return deportes;
    }


    public Deporte getDeportePorNombre(String nombre){
        return deportes.stream().filter(e -> e.getNombre().equals(nombre)).findAny().orElse(null);

    }

    public List<Persona> getPersonas(){
        return personas;
    }

}
