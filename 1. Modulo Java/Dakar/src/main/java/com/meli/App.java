package com.meli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Vehiculo> vehiculos = Arrays.asList(
            new Auto(254.0, 20.0, 23.0, "1453", 1000.0, 4),
            new Auto(258.0, 15.0, 25.0, "2323", 1000.0, 4),
            new Auto(250.0, 22.0, 230.0, "9876", 1000.0, 4)
        );
        Carrera carrera = new Carrera(253.5, 10000, "Silverstone", 4);

        for (Vehiculo vehiculo : vehiculos) {
            carrera.darAltaAuto(vehiculo.getVelocidad(), vehiculo.getAceleracion(), vehiculo.getAnguloDeGiro(), vehiculo.getPatente());
        }

        Vehiculo ganador = carrera.definirGanador();
        System.out.println("el vehiculo ganador de la carrera fue: " + ganador.toString());
    }
}
