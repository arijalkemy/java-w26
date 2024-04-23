package org.bootcamp;

import org.bootcamp.domain.Carrera;
import org.bootcamp.domain.TipoVehiculo;
import org.bootcamp.domain.Vehiculo;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // Se instancian la carrera
        Carrera carrera = new Carrera(1000D, 20000D, "Grand prix", 6 );

        // Se instancian los vehiculos
        Vehiculo auto1 = new Vehiculo(100, 4.5, 30D, "ABC123", TipoVehiculo.CARRO);
        Vehiculo moto1 = new Vehiculo(80, 2.5, 18D, "CDF123", TipoVehiculo.MOTO);


        System.out.println("Hello World!");
    }
}
