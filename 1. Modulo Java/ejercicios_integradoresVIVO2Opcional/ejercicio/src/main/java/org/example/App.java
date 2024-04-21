package org.example;

import org.example.models.*;
import org.example.repository.AeropuertoRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        AeropuertoRepository aeropuertos = new AeropuertoRepository();
        Pasajero pasajero1 = new Pasajero("Daniel");
        Pasajero pasajero2 = new Pasajero("John");
        Pasajero pasajero3 = new Pasajero("Jane");
        Pasajero pasajero4 = new Pasajero("Bob");
        Pasajero pasajero5 = new Pasajero("Sofia");

        Ciudad ciudad = new Ciudad("Madrid");
        Ciudad ciudad1 = new Ciudad("Barcelona");
        Ciudad ciudad2 = new Ciudad("Valencia");
        Ciudad ciudad3 = new Ciudad("Londres");
        Ciudad ciudad4 = new Ciudad("Bogota");

        Avion avion = new Avion();

        Vuelo vuelo = new Vuelo();

    }
}
