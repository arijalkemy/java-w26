package org.example.Ejercicios_Integradores_P1.SINC.Dakar;

import org.example.Ejercicios_Integradores_P1.SINC.Dakar.Vehiculos.Auto;
import org.example.Ejercicios_Integradores_P1.SINC.Dakar.Vehiculos.Moto;
import org.example.Ejercicios_Integradores_P1.SINC.Dakar.Vehiculos.Vehiculo;

import java.util.ArrayList;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>(Arrays.asList(new Auto(100, 10, 20, "ABC123"),
                new Moto(120, 15, 30, "DEF456"),
                new Auto(90, 8, 15, "GHI789"),
                new Moto(100, 12, 25, "JKL012T")));

        Carrera carrera = new Carrera(10000, 5000, "Carrera Dakar", 3, vehiculos);
        carrera.darDeAltaAuto(400, 100, 20, "ABC123");
        System.out.println(carrera.getVehiculos().size());
        carrera.ganador();

        carrera.darDeAltaSocorristaAuto("Socorrista Auto 1");
        carrera.darDeAltaSocorristaMoto("Socorrista Moto 1");



    }
}
