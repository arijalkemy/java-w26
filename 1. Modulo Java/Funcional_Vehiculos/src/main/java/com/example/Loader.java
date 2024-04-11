package com.example;

import java.util.List;

public class Loader {
    
    public static List<Vehiculo> VEHICULOS;

    public static void load(){
        Vehiculo[] temp = new Vehiculo[]{
            new Vehiculo("Fiesta","Ford",1000),
            new Vehiculo("Focus", "Ford", 1200),
            new Vehiculo("Explorer", "Ford", 2500),
            new Vehiculo("Uno", "Fiat", 500),
            new Vehiculo("Cronos", "Fiat", 1000),
            new Vehiculo("Torino", "Fiat", 1250),
            new Vehiculo("Aveo", "Chevrolet", 1250),
            new Vehiculo("Spin", "Chevrolet", 2500),
            new Vehiculo("Corola", "Toyota", 1200),
            new Vehiculo("Fortuner", "Toyota", 3000),
            new Vehiculo("Logan", "Renault", 950)
        };
        VEHICULOS = List.of(temp);
    }
}
