package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>(){{
            add(new Vehiculo("Ford","Fiesta",1000));
            add(new Vehiculo("Ford","Focus",1200));
            add(new Vehiculo("Ford","Explorer",2500));
            add(new Vehiculo("Fiat","Uno",500));
            add(new Vehiculo("Fiat","Cronos",1000));
            add(new Vehiculo("Fiat","Torino",1250));
            add(new Vehiculo("Chevrolet","Aveo",1250));
            add(new Vehiculo("Chevrolet","Spin",2500));
            add(new Vehiculo("Toyota","Corola",1200));
            add(new Vehiculo("Toyota","Fortuner",3000));
            add(new Vehiculo("Renault","Logan",950));
        }};

            String garageId = UUID.randomUUID().toString();
            Garage garage = new Garage(garageId, vehiculos);
            garage.imprimirListaVehiculosPorPrecio();
            garage.imprimirListaVehiculosPorMarcaYPrecio();
            garage.imprimirListaVehiculosNoMayorAPrecio1000();
            garage.imprimirListaVehiculosPrecioMayorIgual1000();
    }
}
