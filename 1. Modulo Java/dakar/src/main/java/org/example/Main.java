
package org.example;

import org.example.clases.Carrera;

public class Main
{
    public static void main( String[] args )
    {

        Carrera carreraUno = new Carrera(1000,300000,"Adelaida",12);

        carreraUno.darDeAltaAuto(100,12,12,"AAA-111");
        carreraUno.darDeAltaAuto(220,8,20,"BBB-222");
        carreraUno.darDeAltaAuto(120,10,10,"CCC-333");
        carreraUno.darDeAltaAuto(230,18,61,"DDD-444");
        carreraUno.darDeAltaAuto(280,9,40,"FFF-555");

        System.out.println(carreraUno.ganador());

    }
}
