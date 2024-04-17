package com.example.deportista.repository;

import com.example.deportista.entities.Deporte;


import java.util.ArrayList;
import java.util.List;


public class DeporteRepository {

    public static List<Deporte> deportes = new ArrayList<>();
    static {



    }

    public List<Deporte> obtenerDeportes(){
        List<Deporte> desportes = new ArrayList<>();
        deportes.add(new Deporte("Beisbol",3));
        deportes.add(new Deporte("MotoGP",5));
        deportes.add(new Deporte("Atletismo",4));
        deportes.add(new Deporte("Basquetbol",2));
        deportes.add(new Deporte("Futsala",5));
        return desportes;
    }

}
