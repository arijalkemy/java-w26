package org.example;

import org.example.socorristas.SocorristaAuto;
import org.example.socorristas.SocorristaMoto;
import org.example.vehiculos.Vehiculo;

import java.util.Optional;

public class App
{
    public static void main( String[] args )
    {
        Carrera unaCarreraDelDakar = new Carrera();

        unaCarreraDelDakar.agregarSocorristaMoto(new SocorristaMoto(), new SocorristaMoto(), new SocorristaMoto());
        unaCarreraDelDakar.agregarSocorristasAuto(new SocorristaAuto(), new SocorristaAuto(), new SocorristaAuto());

        unaCarreraDelDakar.darDeAltaMoto(180, 60, 80.8, "12345");
        unaCarreraDelDakar.darDeAltaAuto(240, 50, 50.5, "112233");

        Optional<Vehiculo> posibleGanador = unaCarreraDelDakar.ganador();

        if(posibleGanador.isPresent()) {
            System.out.println("El ganador fue " + posibleGanador);
        }

        unaCarreraDelDakar.socorrerAuto("12345");
        unaCarreraDelDakar.socorrerMoto("112233");
    }
}
