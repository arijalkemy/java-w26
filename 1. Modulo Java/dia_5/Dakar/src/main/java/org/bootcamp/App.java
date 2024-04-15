package org.bootcamp;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Auto auto1 = new Auto(300.0, 100.0, 75.0, "AJK 197");
        Carrera carrera = new Carrera(174.5, 1000.0, "nueva carrera", 5);

        System.out.println("----------------------------------------------------------------------------------");

        carrera.eliminarVehiculo(auto1);
        carrera.darDeAltaAuto(300.0, 100.0, 75.0, "AJK 197");
        carrera.darDeAltaAuto(270.0, 84.0, 90.0, "PPP 223");
        carrera.darDeAltaAuto(270.0, 84.0, 90.0, "PPP 223");

        System.out.println("----------------------------------------------------------------------------------");

        carrera.darDeAltaMoto(150.0, 59.7, 34.2, "MOT 069");
        carrera.darDeAltaMoto(350.0, 7.3, 150.0, "ONE 234");
        carrera.darDeAltaMoto(350.0, 7.3, 150.0, "ONE 234");

        System.out.println("----------------------------------------------------------------------------------");

        carrera.socorrerAuto("AJK 197");
        carrera.socorrerAuto("BBB 267");
        carrera.socorrerMoto("MOT 069");
        carrera.socorrerMoto("ONE 234");
    }
}
