package org.meli;
import org.meli.clases.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Carrera carrera = new Carrera(1000.0, 50000.0, "Gran Carrera", 5, new SocorristaAuto(), new SocorristaMoto());
        carrera.darDeAltaAuto(240.0, 10.0, 40.0, "ABC123");
        carrera.darDeAltaMoto(200.0, 12.0, 45.0, "DEF45C");
        carrera.darDeAltaAuto(250.0, 11.0, 42.0, "GHI789");
        carrera.darDeAltaMoto(160.0, 8.0, 60.0, "JKL01G");
        carrera.darDeAltaAuto(230.0, 9.0, 38.0, "MNO456");

        carrera.imprimirParticipantes();

        carrera.darDeAltaMoto(180.0, 10.0, 50.0, "PQR23T");

        System.out.println("\nDESPUES DE FALLAR EN AGREGAR MOTO");
        carrera.imprimirParticipantes();

        carrera.eliminarVehiculoConPatente("DEF45C");
        System.out.println("\nDESPUES DE ELIMINAR MOTO");
        carrera.imprimirParticipantes();

        System.out.println("\nSOCORRER VEHICULOS");
        carrera.socorrerAuto("GHI789");
        carrera.socorrerMoto("JKL01G");
        carrera.socorrerAuto("JKL01G");



    }
}
