package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {

        //registramos los vehiculos
        Carrera dakarArgentina = new Carrera(140,1200,"Dakar", 5);
        dakarArgentina.darDeAltaAuto(180,80,30, "A1312");
        dakarArgentina.darDeAltaAuto(120,70,30, "B1312");
        dakarArgentina.darDeAltaAuto(115,60,30, "C1312");
        dakarArgentina.darDeAltaMoto(240,90,30, "D1312");
        dakarArgentina.darDeAltaMoto(270,80,30, "E1312");
        dakarArgentina.darDeAltaMoto(280,80,30, "F1312");

        dakarArgentina.calcularGandor();

        //Socorremos algunos vehiculos
        dakarArgentina.socorrerAuto("A1312");
        dakarArgentina.socorrerMoto("E1312");

    }
}
