import interfaces.TipoDeVuelo;
import modelo.*;
import repositorios.RepositorioVuelos;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

        RepositorioVuelos repositorioVuelos = new RepositorioVuelos();

        Ciudad bsAs = new Ciudad("Buenos Aires");
        Ciudad milan = new Ciudad("Milan");
        Ciudad barcelona = new Ciudad("Barcelona");

        Persona persona1 = new Persona("Nacho");
        Persona persona2 = new Persona("Julieta");
        Persona persona3 = new Persona("Felipe");

        Aerolinea aerolinea = new Aerolinea("Aerolinea");

        Aeropuerto aeropuertoEzeiza = new Aeropuerto("Aeropuerto Ezeiza", bsAs);
        Aeropuerto aeropuertoMilan = new Aeropuerto("Aeropuerto Milan", milan);
        Aeropuerto aeropuertoBarcelona = new Aeropuerto("Aeropuerto Barcelona", barcelona);

        bsAs.agregarAeropuerto(aeropuertoEzeiza);
        milan.agregarAeropuerto(aeropuertoMilan);
        barcelona.agregarAeropuerto(aeropuertoBarcelona);

        Escala escalaBarcelonaToMilan = new Escala(aeropuertoBarcelona, aeropuertoMilan, 3, null);
        Escala escalaBsAsToBarcelona = new Escala(aeropuertoEzeiza, aeropuertoBarcelona, 12, escalaBarcelonaToMilan);


        TipoDeVuelo vueloDirectoBsAsToMilan = new VueloDirecto(12);
        TipoDeVuelo vueloConEscalasBsAsToMilan = new VueloConEscalas(Arrays.asList(escalaBsAsToBarcelona,escalaBarcelonaToMilan));

        Vuelo bsAsToMilanDirecto = new Vuelo(aeropuertoEzeiza, aeropuertoMilan, vueloDirectoBsAsToMilan, 5, LocalDate.now());
        Vuelo bsAsToMilanConEscalas = new Vuelo(aeropuertoEzeiza,aeropuertoMilan,vueloConEscalasBsAsToMilan,5, LocalDate.now());

        Pasajero pasajero1 = new Pasajero(persona1, 1, bsAsToMilanDirecto);
        Pasajero pasajero2 = new Pasajero(persona2, 2, bsAsToMilanDirecto);
        Pasajero pasajero3 = new Pasajero(persona3, 3, bsAsToMilanDirecto);

        bsAsToMilanDirecto.agregarPasajero(pasajero1);
        bsAsToMilanDirecto.agregarPasajero(pasajero2);
        bsAsToMilanDirecto.agregarPasajero(pasajero3);

        bsAsToMilanConEscalas.agregarPasajero(pasajero1);
        bsAsToMilanConEscalas.agregarPasajero(pasajero3);

        bsAsToMilanDirecto.mostrarCapacidadOcupada();

        repositorioVuelos.agregarVuelo(bsAsToMilanDirecto);
        repositorioVuelos.agregarVuelo(bsAsToMilanConEscalas);

        System.out.println("Cuantos vuelos llegaron a Milan: ");
        System.out.println(repositorioVuelos.cantidadDeVuelosQueLlegaronA(aeropuertoMilan));

        System.out.println("Cuantos vuelos llegaron a Barcelona: ");
        System.out.println(repositorioVuelos.cantidadDeVuelosQueLlegaronA(aeropuertoBarcelona));

        System.out.println("Cuantos vuelos llegaron a Buenos Aires: ");
        System.out.println(repositorioVuelos.cantidadDeVuelosQueLlegaronA(aeropuertoEzeiza));

        System.out.println();

        System.out.println("Cuantos vuelos salieron de Milan: ");
        System.out.println(repositorioVuelos.cantidadDeVuelosQueSalieronDe(aeropuertoMilan));

        System.out.println("Cuantos vuelos salieron de Barcelona: ");
        System.out.println(repositorioVuelos.cantidadDeVuelosQueSalieronDe(aeropuertoBarcelona));

        System.out.println("Cuantos vuelos salieron de Buenos Aires: ");
        System.out.println(repositorioVuelos.cantidadDeVuelosQueSalieronDe(aeropuertoEzeiza));


        System.out.println("Aeropuerto con menos escalas");
        System.out.println(
                repositorioVuelos.obtenerAeropuertoConMenosEscalas(
                    Arrays.asList(aeropuertoBarcelona,aeropuertoMilan,aeropuertoEzeiza)
            )
        );


        System.out.println("Cantidad de aeropuertos en Ezeiza");
        System.out.println(bsAs.getAeropuertos().size());


        System.out.println("Ciudad que arribo mas pasajeros");
        System.out.println(repositorioVuelos.obtenerCiudadQueRecibioMasPasajeros(Arrays.asList(
                milan,bsAs,barcelona
        )));
    }
}
