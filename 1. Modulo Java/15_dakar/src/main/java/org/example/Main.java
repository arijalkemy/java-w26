package org.example;

import org.example.entity.Carrera;
import org.example.enums.VehiclesEnum;

public class Main {
    public static void main(String[] args) {
        Carrera dakar = new Carrera(
                2000.50,
                24547859.20,
                "Dakar",
                100
        );
        // ----

        dakar.darDeAltaVehiculo(
                350.50,
                100.22,
                60.4,
                "ART-566",
                VehiclesEnum.AUTO
        );
        dakar.darDeAltaVehiculo(
                325.00,
                150.22,
                90.2,
                "AD-222-222",
                VehiclesEnum.AUTO
        );
        dakar.darDeAltaVehiculo(
                201.22,
                87.2,
                90.11,
                "SDSD-2222",
                VehiclesEnum.MOTO
        );

        // ----
        System.out.println("Ganador de la carrera: " + dakar.ganadorCarrera());

    }
}