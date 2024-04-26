package com.deporte.deportistas.Repository;

import com.deporte.deportistas.Model.Deporte;

import java.util.List;

public class DeporteRepository {

    public final List<Deporte> deportes = List.of(new Deporte("Futbol", 1),
                                                new Deporte("Basquet", 1),
                                                new Deporte("Voley", 2),
                                                new Deporte("Golf", 3));

    public List<Deporte> getDeportes(){ return this.deportes;}

    public Deporte getDeporteByName(String nombre){ return this.deportes.stream()
                                                                        .filter(p -> p.getNombre().equals(nombre))
                                                                        .findFirst().get();}
}
