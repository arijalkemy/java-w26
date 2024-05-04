package com.meli;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal que ejecuta la aplicación.
 */
public class Main {
    /**
     * Método principal que se ejecuta al iniciar la aplicación.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {

        // Creación de autos
        Auto auto = new Auto(1, 100, 10, "AAA123");
        Auto auto2 = new Auto(2, 150, 15, "BBB123");
        Auto auto3 = new Auto(3, 200, 20, "CCC123");

        // Creación de motos
        Moto moto = new Moto(2, 50, 5, "BBB123");
        Moto moto2 = new Moto(3, 80, 8, "CCC123");
        Moto moto3 = new Moto(4, 120, 12, "DDD123");

        // Creación de socorristas
        SocorristaAuto socorristaAuto = new SocorristaAuto();
        SocorristaMoto socorristaMoto = new SocorristaMoto();

        // Creación de la lista de vehículos
        List<Vehiculo> listavehiculos = new ArrayList<>();
        listavehiculos.add(auto);
        listavehiculos.add(auto2);
        listavehiculos.add(auto3);
        listavehiculos.add(moto);
        listavehiculos.add(moto2);
        listavehiculos.add(moto3);

        // Imprimir la lista de competidores
        System.out.println("Lista de competidores: ");
        listavehiculos.forEach(System.out::println);

        // Creación de la carrera
        Carrera carrera = new Carrera(1000, 5000, "Carrera 1",8,listavehiculos);

        // Eliminar un vehículo de la carrera
        carrera.eliminarVehiculo(moto);

        // Imprimir la lista de competidores actualizada
        System.out.println("Lista de competidores actualizada: ");
        listavehiculos.forEach(System.out::println);

        // Eliminar un vehículo de la carrera por su patente
        carrera.eliminarPorPaatente(auto2.getPatente());

        // Imprimir la lista de competidores actualizada
        System.out.println("Lista de competidores actualizada: ");
        listavehiculos.forEach(System.out::println);

        // Socorrer a los vehículos
        socorristaMoto.socorrer(moto3);
        socorristaAuto.socorrer(auto3);

        // Calcular e imprimir el ganador de la carrera
        System.out.println("El ganador es: "+carrera.calcularGanador() + " Felicidades!!");
    }
}