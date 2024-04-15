package org.example;

import org.example.clases.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Hello world!
 *
 */
public class GestionDeVuelos
{
    public static void main( String[] args )
    {
        Persona persona = new Persona("marcos", "bellotti", 112, new RolDePersona("Pasajero", "Es pasajero"));

        Aeropuerto aeropuertoCordoba = new Aeropuerto("Cordoba aeropuerto", "Esta sobre la autopista");
        Aeropuerto aeropuertoEzeiza = new Aeropuerto("Ezeiza", "Esta en la ciudad de Bs As");
        Aeropuerto aeroparque = new Aeropuerto("Aeroparque", "Esta sobre la autopista");

        List<Aeropuerto> aeropuertosCordoba = new ArrayList<Aeropuerto>();
        aeropuertosCordoba.add(aeropuertoCordoba);

        List<Aeropuerto> aeropuertosBsAs = new ArrayList<Aeropuerto>();
        aeropuertosBsAs.add(aeropuertoEzeiza);
        aeropuertosBsAs.add(aeroparque);

        Ciudad cordoba = new Ciudad("Cordoba", aeropuertosCordoba);
        Ciudad buenosAires = new Ciudad("Buenos Aires", aeropuertosBsAs);

        List<Ciudad> ciudades = new ArrayList<Ciudad>();
        ciudades.add(cordoba);
        ciudades.add(buenosAires);

        Pais argentina = new Pais("Argentina",ciudades);

        Avion avion = new Avion("Boeing", "797", 50, 300);

        Vuelo vueloCordobaBsAs = new Vuelo(0, avion, aeropuertoCordoba, aeropuertoEzeiza,
                2.5, new Date(2022 - 1900, 0, 1),
                                        new Date(2022 - 1900, 0, 1));
        vueloCordobaBsAs.agregarEscalas(new Escala(aeroparque, 2));

        Vuelo vueloCordobaBsAs1 = new Vuelo(1, avion, aeropuertoCordoba, aeropuertoEzeiza,
                2.5, new Date(2022 - 1900, 0, 1),
                                        new Date(2022 - 1900, 0, 1));
        Vuelo vueloCordobaBsAs2 = new Vuelo(1, avion, aeropuertoCordoba, aeroparque,
                2.5, new Date(2022 - 1900, 0, 1),
                new Date(2022 - 1900, 0, 1));
        Vuelo vueloBsAsCordoba = new Vuelo(2, avion,aeropuertoEzeiza, aeropuertoCordoba,
                2.5, new Date(2022 - 1900, 0, 3),
                                            new Date(2022 - 1900, 0, 1));
        vueloBsAsCordoba.agregarEscalas(new Escala(aeroparque, 0.5));
        vueloBsAsCordoba.agregarEscalas(new Escala(aeroparque, 0.5));
        vueloBsAsCordoba.agregarEscalas(new Escala(aeroparque, 0.5));

        GestorDeVuelos gestorDeVuelos = new GestorDeVuelos();
        gestorDeVuelos.agregarVuelo(vueloCordobaBsAs);
        gestorDeVuelos.agregarVuelo(vueloCordobaBsAs1);
        gestorDeVuelos.agregarVuelo(vueloCordobaBsAs2);
        gestorDeVuelos.agregarVuelo(vueloBsAsCordoba);

        //3 Cantidad de vuelos que partieron y llegaron al aeropuerto
        System.out.println("La cantidad de vuelos que salieron desde el aeropuerto de cordoba ese dia son: " + gestorDeVuelos.cantidadDeVuelosQueSalieronDelAeropuerto(aeropuertoCordoba, new Date(2022 - 1900, 0, 1)));
        System.out.println("La cantidad de vuelos que llegaron al aeropuerto de cordoba ese dia son: " + gestorDeVuelos.cantidadDeVuelosQueLlegaronAlAeropuerto(aeropuertoCordoba, new Date(2022 - 1900, 0, 1)));


        //4 El aeropuerto que recibio menos vuelos en escalas
        System.out.println("El aeropuerto que recibio menos vuelos en escalas es: " + gestorDeVuelos.aeropuertoQueRecibioMenosVuelosEnEscalas().getNombre());

        //5 cantidad de vuelos totales de un pasajero
        vueloBsAsCordoba.agregarBoleto(new Boleto(persona, new TipoDeBoleto("Turistico", "no tiene")));
        vueloBsAsCordoba.agregarBoleto(new Boleto(persona, new TipoDeBoleto("Turistico", "no tiene")));
        vueloCordobaBsAs1.agregarBoleto(new Boleto(persona, new TipoDeBoleto("Primera clase", "no tiene")));

        System.out.println("La cantidad de vuelos de la persona es: " + gestorDeVuelos.obtenerCantidadDeVuelosDeUnPasajero(persona));


        //6 Cantidad de aeropuertos que tiene una ciudad
        System.out.println("La cantidad de aeropuertos Cordoba es: " + cordoba.getAeropuertos().size());
    }
}
