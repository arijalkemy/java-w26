package org.example;

import org.example.dakar.Carrera;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(300.00, 1000,"Andy´s race", 50, new ArrayList<>());

        carrera.darDeAltaAuto(110.00, 22.0, 40, "AA101AA");
        carrera.darDeAltaAuto(105.00, 23.0, 37, "AA999BB");

        // Obtengo Ganador
        System.out.println("Gandor: " + carrera.vehiculoGanador().get().getPatente());



    }
}