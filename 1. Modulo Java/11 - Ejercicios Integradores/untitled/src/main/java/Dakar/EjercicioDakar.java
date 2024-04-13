package Dakar;

import Dakar.clases.Carrera;

/**
 * Hello world!
 *
 */
public class EjercicioDakar
{
    public static void main( String[] args )
    {

        Carrera carreraUno = new Carrera(1234,1000,"Carrea",5);

        carreraUno.darDeAltaAuto(1000000,23,24,"AAA");
        carreraUno.darDeAltaAuto(123123,23,24,"BBB");
        carreraUno.darDeAltaAuto(1,23,24,"CCC");
        carreraUno.darDeAltaAuto(4444,23,24,"DDD");
        carreraUno.darDeAltaAuto(3333,23,24,"FFF");

        System.out.println(carreraUno.ganador());


    }
}
