package org.example;

import org.example.carrera.Carrera;
import org.example.vehiculo.Auto;
import org.example.vehiculo.Moto;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Carrera carr = new Carrera(100, 1000, "Grand Pittz", 5);

        Auto auto1 = new Auto(20, 5, 30, UUID.randomUUID());
        Auto auto2 = new Auto(30, 6, 20, UUID.randomUUID());
        Auto auto3 = new Auto(50, 12, 70, UUID.randomUUID());

        Moto moto1 = new Moto(50, 10, 40, UUID.randomUUID());
        Moto moto2 = new Moto(45, 12, 41, UUID.randomUUID());
        Moto moto3 = new Moto(45, 12, 41, UUID.randomUUID());
        Moto moto4 = new Moto(45, 12, 41, UUID.randomUUID());

        /* Se cargar vehiculos */
        carr.agregarAuto(auto1, auto2, auto3);
        carr.agregarMoto(moto1, moto2, moto3);

        /* Se trata de cargar un vehiculo mas */
//        carr.agregarMoto(moto1, moto2, moto3, moto4);

        /* Se elimina un vehiculo */
        carr.imprimirVehiculos();
        carr.eliminarVehiculo(moto3);
        carr.imprimirVehiculos();

        /* Se localiza el ganador */
        System.out.println("GANADOR");
        System.out.println(carr.determinarGanador().toString());

        /* Socorrer auto */
        carr.socorrerAuto(auto3);
        carr.socorrerAuto(moto1);
        carr.socorrerMoto(auto1);
        carr.socorrerMoto(moto1);
    }
}