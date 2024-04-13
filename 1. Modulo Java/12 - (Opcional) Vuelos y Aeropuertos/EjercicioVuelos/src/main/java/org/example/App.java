package org.example;

import org.example.Impl.AerolineaImpl;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        AerolineaImpl aerolinea = new AerolineaImpl();

        List<Pasajero> pasajeros = List.of(new Pasajero("Esteban", "32567981"),new Pasajero("Jose", "41321981"),new Pasajero("Maria", "25892452"));
        Aeropuerto aeropuertoBSAS = new Aeropuerto("Ezeiza", "Buenos Aires");
        Aeropuerto aeropuertoMD = new Aeropuerto("Barajas", "Madrid");
        Aeropuerto aeropuertoLM = new Aeropuerto("ASF", "Lima");
        Aeropuerto aeropuertoPR = new Aeropuerto("DFG", "Porto");

        Tramo BsaLima = new Tramo(true, aeropuertoBSAS,aeropuertoLM,3.0);
        Tramo LimaMD = new Tramo(false, aeropuertoLM,aeropuertoMD,9.0);

        Vuelo vueloBSaMD = new Vuelo( List.of(BsaLima, LimaMD),pasajeros);
        System.out.println("Cantidad de pasajeros: " + vueloBSaMD.capacidad());
        System.out.println("Duracion: " + vueloBSaMD.duracion());

        aerolinea.altas("13/04/2024", vueloBSaMD);

        System.out.println("AEROPUERTO Ezeiza - BS AS - FECHA 13/04/2024 - ORIGEN: " + aeropuertoBSAS.cantidadVuelosOrigen("13/04/2024") + " - DESTINO: " + aeropuertoBSAS.cantidadVuelosDestino("13/04/2024") );
        System.out.println("AEROPUERTO Barajas - Madrid - FECHA 13/04/2024 - ORIGEN: " + aeropuertoMD.cantidadVuelosOrigen("13/04/2024") + " - DESTINO: " + aeropuertoMD.cantidadVuelosDestino("13/04/2024") );

    }
}
