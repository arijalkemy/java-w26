package com.sinc_ejerciciodeportistas.repositorio;

import com.sinc_ejerciciodeportistas.entidades.Deporte;
import com.sinc_ejerciciodeportistas.entidades.Persona;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {

    public static List<Deporte> listaDeportes;
    public static List<Persona> listaPersonas;

    static {
        listaDeportes = new ArrayList<>();

        listaDeportes.add(new Deporte("Futbol", "Medio"));
        listaDeportes.add(new Deporte("Tenis", "Alto"));
        listaDeportes.add(new Deporte("Baloncesto", "Alto"));
        listaDeportes.add(new Deporte("Natación", "Medio"));
        listaDeportes.add(new Deporte("Atletismo", "Bajo"));

        listaPersonas = new ArrayList<>();

        listaPersonas.add(new Persona("Marcos", "Ditta", 24, listaDeportes.get(0)));
        listaPersonas.add(new Persona("Natalia", "Caceres", 54, listaDeportes.get(1)));
        listaPersonas.add(new Persona("Ignacio", "Ditta", 65, listaDeportes.get(2)));
        listaPersonas.add(new Persona("Bautista", "Granthon", 29, null));
    }


}
