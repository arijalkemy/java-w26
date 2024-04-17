package org.example;

import org.example.model.Carrera;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Crear una carrera
        Carrera carrera = new Carrera(1000, 5000.0, "Gran Premio", 5);

        // Dar de alta algunos vehículos
        carrera.darDeAltaAuto(200, 10, 30, "ABC123");
        carrera.darDeAltaAuto(180, 8, 25, "XYZ456");
        carrera.darDeAltaMoto(150, 12, 35, "DEF789");
        carrera.darDeAltaMoto(160, 10, 30, "GHI012");

        // Mostrar los vehículos en la carrera
        System.out.println("Vehículos en la carrera:");
        System.out.println(carrera.mostrarVehiculos());

        // Socorrer un auto
        carrera.socorrerAuto("ABC123");

        // Socorrer una moto
        carrera.socorrerMoto("GHI012");

        // Definir el ganador de la carrera
        System.out.println(carrera.obtenerGanador());
    }
}