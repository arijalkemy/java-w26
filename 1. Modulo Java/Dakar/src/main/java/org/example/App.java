package org.example;

import org.example.socorrista.SocorristaAuto;
import org.example.socorrista.SocorristaMoto;
import org.example.vehiculo.Auto;
import org.example.vehiculo.Vehiculo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SocorristaAuto socorristaAuto = new SocorristaAuto();
        SocorristaMoto socorristaMoto = new SocorristaMoto();



        Carrera carrera = new Carrera(30.00,1500.00,"Carreras Locas",8,socorristaAuto,socorristaMoto);
        carrera.darDeAltaAuto(30.21,33.00,14.00,"ABC-123");
        carrera.darDeAltaAuto(25.50, 31.75, 12.50, "DEF-456");
        carrera.darDeAltaAuto(28.75, 36.20, 15.80, "GHI-789");
        carrera.darDeAltaAuto(32.40, 38.90, 17.30, "JKL-012");
        carrera.darDeAltaMoto(44.00, 30.00, 90.00, "23-ABE-41E");
        carrera.darDeAltaMoto(40.50, 32.75, 85.00, "65-XCD-82F");
        carrera.darDeAltaMoto(46.20, 28.90, 88.50, "98-EFG-33H");
        carrera.darDeAltaMoto(42.80, 35.60, 91.20, "12-IJK-74L");
        carrera.darDeAltaMoto(40.50, 32.75, 85.00, "65-XCD-82F");

        carrera.mostrarCompetidores();

        carrera.ganador();
        carrera.socorrerAuto("DEF-456");
        carrera.socorrerAuto("e");
        carrera.socorrerAuto("23-ABE-41E");

        carrera.socorrerMoto("23-ABE-41E");

        Vehiculo vehiculo = carrera.getVehiculoList().get(0);
        carrera.eliminarVehiculo(vehiculo);
        carrera.eliminarVehiculoConPatente("DEF-456");
        carrera.mostrarCompetidores();
    }

}
