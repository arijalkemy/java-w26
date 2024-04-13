package org.example;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        List<Vehiculo> vehiculos = new ArrayList<>();

        Autos auto1 = new Autos(120, 10, 30, "ABC123");
        Autos auto2 = new Autos(150, 25, 10, "DFG123");
        Motos moto1 = new Motos(100, 15, 40, "XYZ789");

        vehiculos.add(auto1);
        vehiculos.add(auto2);
        vehiculos.add(moto1);

        List<Vehiculo> socorristas = new ArrayList<>();

        SocorristaAuto socorristaAuto = new SocorristaAuto(0, 0, 0, "", 0, 0);
        SocorristaMoto socorristaMoto = new SocorristaMoto(0, 0, 0, "", 0, 0);

        socorristas.add(socorristaAuto);
        socorristas.add(socorristaMoto);

        Carrera carrera = new Carrera(1000, 5000, "Carrera 1", 10, vehiculos, socorristas);

        carrera.socorrerAuto("ABC123");
        carrera.socorrerMoto("XYZ789");

        carrera.ganadorCarrera();
    }
}
