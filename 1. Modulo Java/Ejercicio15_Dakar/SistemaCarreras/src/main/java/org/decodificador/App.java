package org.decodificador;

import org.decodificador.logica.Carrera;
import org.decodificador.logica.ISocorristaVehiculo;
import org.decodificador.logica.VehiculoConcreto;

public class App
{
    public static void main( String[] args )
    {
        System.out.println("------------------------------------------------");
        System.out.println( "Carrera de automoviles");
        Carrera carrera = new Carrera(100, 1000000000, "Vuelta Roma", 8);
        //Inscripcion de los jugadores a la carrera
        System.out.println("------------------------------------------------");
        System.out.println("Registrando autos");
        carrera.darDeAltaAuto(new VehiculoConcreto(78.3, 279, "ABC133", 499.9, 4, 5.7, "Auto"));
        carrera.darDeAltaAuto(new VehiculoConcreto(29.8, 220.9, "ABC463", 481.3, 4, 6.5, "Auto"));
        carrera.darDeAltaAuto(new VehiculoConcreto(52.3, 294.7, "ABC999", 400.9, 4, 5.4, "Auto"));
        carrera.darDeAltaAuto(new VehiculoConcreto(6.5, 194.9, "ABC738", 409.2, 4, 3.5, "Auto"));
        carrera.darDeAltaAuto(new VehiculoConcreto(20.0, 218.5, "ABC213", 465.1, 4, 3.5, "Auto"));
        carrera.darDeAltaAuto(new VehiculoConcreto(20.8, 166.4, "ABC963", 421.7, 4, 4.0, "Auto"));
        carrera.darDeAltaAuto(new VehiculoConcreto(57.5, 10.8, "ABC434", 495.6, 4, 7.6, "Auto"));
        carrera.darDeAltaAuto(new VehiculoConcreto(60.8, 198.3, "ABC512", 441.4, 4, 6.3, "Auto"));
        carrera.darDeAltaAuto(new VehiculoConcreto(31.1, 19.5, "ABC371", 414.0, 4, 3.7, "Auto"));
        carrera.darDeAltaAuto(new VehiculoConcreto(42.1, 316.7, "ABC762", 419.7, 4, 4.8, "Auto"));
        System.out.println("------------------------------------------------");
        System.out.println("Autos registrados:");
        carrera.mostrarCompetidores(carrera.getListaAutomoviles());
        System.out.println("------------------------------------------------");
        System.out.println("Descalificar auto con patente: ABC463");
        //Eliminando un jugador por patente
        carrera.eliminarVehiculoAutomovil("ABC463");
        System.out.println("------------------------------------------------");
        //Socorrer a un auto
        carrera.socorrerAutomovil(carrera.getListaAutomoviles().get(0));
        System.out.println("------------------------------------------------");
        System.out.println("Orden de la carrera:");
        carrera.definirGanador(carrera.getListaAutomoviles()).forEach(System.out::println);
        

    }
}
