package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Race;
import com.example.model.Vehicle;

public class App {
    public static void main(String[] args) {
        List<Vehicle> vehiclesToCarRace = new ArrayList<>();
        Race carRace = new Race(1000, 500000, "La copa pistón", 9, vehiclesToCarRace);

        Vehicle auto1 = new Vehicle("Auto", 100, 9.8, 30, 1500, 4, "a1");
        Vehicle auto2 = new Vehicle("Auto", 120, 10.5, 28, 1600, 4, "a2");
        Vehicle auto3 = new Vehicle("Auto", 110, 9.0, 32, 1550, 4, "a3");
        Vehicle auto4 = new Vehicle("Auto", 90, 8.2, 35, 1450, 4, "a4");
        Vehicle auto5 = new Vehicle("Auto", 130, 11.0, 26, 1650, 4, "a5");
        Vehicle auto6 = new Vehicle("Auto", 95, 7.5, 38, 1400, 4, "a6");
        Vehicle auto7 = new Vehicle("Auto", 115, 9.3, 31, 1520, 4, "a7");
        Vehicle auto8 = new Vehicle("Auto", 85, 8.0, 36, 1480, 4, "a8");
        Vehicle auto9 = new Vehicle("Auto", 125, 10.0, 29, 1580, 4, "a9");
        Vehicle auto10 = new Vehicle("Auto", 105, 9.5, 33, 1530, 4, "a10");

        // Registrando vehículos
        carRace.registerVehicle(auto1);
        carRace.registerVehicle(auto2);
        carRace.registerVehicle(auto3);
        carRace.registerVehicle(auto4);
        carRace.registerVehicle(auto5);
        carRace.registerVehicle(auto6);
        carRace.registerVehicle(auto7);
        carRace.registerVehicle(auto8);
        carRace.registerVehicle(auto9);

        // Carrera Llena!
        carRace.registerVehicle(auto10);

        // ELiminando vehículo
        carRace.deleteVehicle(auto9);
        carRace.deleteVehicle("a8");

        // Socorriendo vehículos
        carRace.helpVehicle(auto1);
        carRace.helpVehicle("a4");

        // Determinando gana
        carRace.winner(vehiclesToCarRace);

    }
}
