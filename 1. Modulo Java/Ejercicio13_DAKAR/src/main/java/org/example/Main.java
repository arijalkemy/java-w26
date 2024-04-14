package org.example;

public class Main {
    public static void main(String[] args) {

        Carrera carrera = new Carrera(12331.2, 9992342, "Carrera MELI", 10, new SocorristaAuto(), new SocorristaMoto());
        carrera.darDeAltaAuto(1234, 123, 234, "A");
        carrera.darDeAltaAuto(125, 523, 232, "B");
        carrera.darDeAltaAuto(432, 123, 52, "C");
        carrera.darDeAltaAuto(145, 341, 121, "D");
        carrera.darDeAltaAuto(165, 345, 127, "E");
        carrera.socorrerAuto("A");
        carrera.socorrerMoto("D");
        Auto auto = new Auto(1234, 123, 234, "A");
        carrera.eliminarVehiculo(auto);
        carrera.eliminarVehiculoConPatente("D");
        System.out.println("Patente Campeón: " + carrera.getCampeon().getPatente());
    }
}