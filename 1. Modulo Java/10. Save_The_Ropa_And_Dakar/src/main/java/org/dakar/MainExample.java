package org.dakar;

import org.dakar.socorristas.SocorristaAuto;
import org.dakar.socorristas.SocorristaMoto;
import org.dakar.vehiculos.TipoDeVehiculo;
import org.dakar.vehiculos.Vehiculo;

import java.util.Optional;

public class MainExample {

    public static void main(String[] args) {
        Carrera unaCarreraDelDakar = new Carrera();

        unaCarreraDelDakar.agregarSocorristaMoto(new SocorristaMoto(), new SocorristaMoto(), new SocorristaMoto());
        unaCarreraDelDakar.agregarSocorristasAuto(new SocorristaAuto(), new SocorristaAuto(), new SocorristaAuto());

        unaCarreraDelDakar.darDeAltaMoto(180, 60, 80.8, "AA899PP");
        unaCarreraDelDakar.darDeAltaAuto(240, 50, 50.5, "AF555IX");

        Optional<Vehiculo> posibleGanador = unaCarreraDelDakar.ganador();

        if (posibleGanador.isPresent()) {
            System.out.println("El ganador fue " + posibleGanador);
        }

        unaCarreraDelDakar.socorrerAuto("AF555IX");
        unaCarreraDelDakar.socorrerMoto("AA899PP");


        // VARIANTE CON MEJORAS, SIN HERENCIA, CON COMPOSICIÓN DE OBJETOS


        TipoDeVehiculo tipoMoto = new TipoDeVehiculo("Moto", 300.0, 2);
        TipoDeVehiculo tipoAuto = new TipoDeVehiculo("Auto", 1000.0, 4);

        Vehiculo unFiestaAzul = new Vehiculo(tipoAuto);
        Vehiculo unRenault12 = new Vehiculo(tipoAuto);
        Vehiculo unC3 = new Vehiculo(tipoAuto);

        Vehiculo unaMotoCualquiera = new Vehiculo(tipoMoto);

    }
}
