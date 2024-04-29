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
        Vehiculo auto2 = new Vehiculo(120, 5D, 20D, "FGE123", TipoVehiculo.CARRO);
        Vehiculo moto2 = new Vehiculo(90, 2D, 15D, "HIJ123", TipoVehiculo.MOTO);

        System.out.println("\n**** CARRERA ****");
        carrera.darDeAltaVehiculo(auto1);
        carrera.darDeAltaVehiculo(moto1);
        carrera.darDeAltaVehiculo(auto2);
        carrera.darDeAltaVehiculo(moto2);

        carrera.listadoDeVehiculos();

        // Se valida lo de socorristas de auto y moto
        carrera.socorrer(auto1);
        carrera.socorrer(moto2);

        // Se elimina un vehiculo de la lista
        carrera.eliminarVehiculo(auto1);
        carrera.listadoDeVehiculos();

        // Se elimina un vehiculo por patente
        carrera.eliminarVehiculoConPatente("CDF123");
        carrera.listadoDeVehiculos();

        // Validar ganador de la carrera
        Vehiculo vehiculoGanador = carrera.ganadorCarrera();
        System.out.println("\nEl vehículo ganador es: " + vehiculoGanador.toString());

        // Se valida lo de socorristas por patente
        carrera.socorrerPorPatente("ACD1234"); // Patente errada
        carrera.socorrerPorPatente("hij123"); // Patente correcta

        System.out.println("\n**** FIN DEL PROGRAMA ****");


    }
}
