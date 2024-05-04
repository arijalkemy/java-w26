package com.meli.ejercicioenvivodto.Modelo;

import com.meli.ejercicioenvivodto.Repository.DTO.DeporteDTO;
import com.meli.ejercicioenvivodto.Repository.DTO.PersonaDTO;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonasList {

    public final static List<PersonaDTO> personas = new ArrayList<>();
    public final static List<DeporteDTO> deporteslist = new ArrayList<>();

    static{
        String[] nombres = {"Juan", "María", "Pedro", "Luis", "Ana", "Carlos", "Laura", "Sofía", "Diego", "Elena"};
        String[] apellidos = {"García", "Martínez", "Rodríguez", "López", "González", "Pérez", "Sánchez", "Díaz", "Romero", "Santiago"};
        String[] deportes = {"Futbol", "Baloncesto", "Tenis", "Natación", "Atletismo"};
        String[] intensidad = {"Alta", "Media", "Baja"};

        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            String nombre = nombres[random.nextInt(nombres.length)];
            String apellido = apellidos[random.nextInt(apellidos.length)];
            String nombreDeporte = deportes[random.nextInt(deportes.length)];

            personas.add(new PersonaDTO(nombre, apellido, nombreDeporte));
        }

        for (String deporte : deportes) {
            deporteslist.add(new DeporteDTO(deporte.toString().toUpperCase(), intensidad[random.nextInt(intensidad.length)]));
        }

    }
}
