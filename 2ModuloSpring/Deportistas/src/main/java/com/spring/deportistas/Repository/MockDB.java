package com.spring.deportistas.Repository;

import com.spring.deportistas.Models.Deporte;
import com.spring.deportistas.Models.Persona;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
@Service

public class MockDB {



    public static final List<Deporte> sportsList = new ArrayList<>();
    public static final List<Persona> personsList = new ArrayList<>();

    static {
        llenarList();
    }






    private static void llenarList() {
        Deporte basquet = new Deporte("Basquet", "Medio");
        Deporte futbol = new Deporte("Futbol", "Medio");
        Deporte handball = new Deporte("Handball", "Bajo");
        Deporte rugby = new Deporte("Rugby", "Alto");
        Deporte paddle = new Deporte("Paddle", "Alto");
        sportsList.add(basquet);
        sportsList.add(futbol);
        sportsList.add(handball);
        sportsList.add(rugby);
        sportsList.add(paddle);

        // Crear personas
        Persona persona1 = new Persona("Juan", "Pérez", new ArrayList<>(List.of(basquet,futbol)), 25);
        Persona persona2 = new Persona("María", "González", new ArrayList<>(List.of(handball,rugby)), 30);
        Persona persona3 = new Persona("Pedro", "Sánchez", new ArrayList<>(List.of(paddle,futbol)), 28);

        personsList.add(persona1);
        personsList.add(persona2);
        personsList.add(persona3);

    }
}
