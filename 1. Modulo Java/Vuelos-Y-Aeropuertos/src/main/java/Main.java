import enums.RolTripulante;
import interfaces.TipoDeVuelo;
import modelo.*;
import repositorios.RepositorioVuelos;
import servicios.Estadisticas;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        RepositorioVuelos repositorioVuelos = RepositorioVuelos.obtenerInstancia();
        Estadisticas estadisticas = new Estadisticas();



        Ciudad bsAs = new Ciudad("Buenos Aires");
        Ciudad milan = new Ciudad("Milan");
        Ciudad barcelona = new Ciudad("Barcelona");

        Persona persona1 = new Persona("Nacho");
        Persona persona2 = new Persona("Julieta");
        Persona persona3 = new Persona("Felipe");

        Aerolinea aerolinea = new Aerolinea("Aerolinea");
        Aerolinea aerolinea1 = new Aerolinea("Aerolinea 2");

        Aeropuerto aeropuertoEzeiza = new Aeropuerto("Aeropuerto Ezeiza", bsAs);
        Aeropuerto aeropuertoMilan = new Aeropuerto("Aeropuerto Milan", milan);
        Aeropuerto aeropuertoBarcelona = new Aeropuerto("Aeropuerto Barcelona", barcelona);

        bsAs.agregarAeropuerto(aeropuertoEzeiza);
        milan.agregarAeropuerto(aeropuertoMilan);
        barcelona.agregarAeropuerto(aeropuertoBarcelona);

        Escala escalaBarcelonaToMilan = new Escala(aeropuertoBarcelona,
                aeropuertoMilan,
                3,
                null,
                LocalDate.now());
        Escala escalaBsAsToBarcelona = new Escala(aeropuertoEzeiza,
                aeropuertoBarcelona,
                12,
                escalaBarcelonaToMilan,
                LocalDate.now());


        TipoDeVuelo directoBsAsToMilan = new VueloDirecto(12);
        TipoDeVuelo conEscalasBsAsToMilan = new VueloConEscalas(Arrays.asList(escalaBsAsToBarcelona,escalaBarcelonaToMilan));

        Vuelo vueloBsAsToMilanDirecto = new Vuelo(aeropuertoEzeiza,
                aeropuertoMilan,
                directoBsAsToMilan,
                5,
                LocalDate.now().minusMonths(1));
        Vuelo vueloBsAsToMilanConEscalas = new Vuelo(aeropuertoEzeiza,
                aeropuertoMilan,
                conEscalasBsAsToMilan,
                5,
                LocalDate.now().minusMonths(1));

        aerolinea.agregarVuelo(vueloBsAsToMilanDirecto);
        aerolinea.agregarVuelo(vueloBsAsToMilanConEscalas);

        aerolinea1.agregarVuelo(vueloBsAsToMilanConEscalas);
        aerolinea1.agregarVuelo(vueloBsAsToMilanConEscalas);
        aerolinea1.agregarVuelo(vueloBsAsToMilanConEscalas);

        Pasajero pasajero1 = new Pasajero(persona1, 1, vueloBsAsToMilanDirecto);
        Pasajero pasajero2 = new Pasajero(persona2, 2, vueloBsAsToMilanDirecto);
        Pasajero pasajero3 = new Pasajero(persona3, 3, vueloBsAsToMilanDirecto);

        vueloBsAsToMilanDirecto.agregarPasajero(pasajero1);
        vueloBsAsToMilanDirecto.agregarPasajero(pasajero2);
        vueloBsAsToMilanDirecto.agregarPasajero(pasajero3);

        List<Tripulante> tripulacion = obtenerTripulacion();

        vueloBsAsToMilanDirecto.setTripulacion(tripulacion);
        vueloBsAsToMilanConEscalas.setTripulacion(tripulacion);

        vueloBsAsToMilanConEscalas.agregarPasajero(pasajero1);
        vueloBsAsToMilanConEscalas.agregarPasajero(pasajero3);

        vueloBsAsToMilanDirecto.mostrarCapacidadOcupada();

        repositorioVuelos.agregarVuelo(vueloBsAsToMilanDirecto);
        repositorioVuelos.agregarVuelo(vueloBsAsToMilanConEscalas);

        System.out.println("Cuantos vuelos llegaron a Milan: ");
        System.out.println(estadisticas.cantidadDeVuelosQueLlegaronA(aeropuertoMilan));

        System.out.println("Cuantos vuelos llegaron a Barcelona: ");
        System.out.println(estadisticas.cantidadDeVuelosQueLlegaronA(aeropuertoBarcelona));

        System.out.println("Cuantos vuelos llegaron a Buenos Aires: ");
        System.out.println(estadisticas.cantidadDeVuelosQueLlegaronA(aeropuertoEzeiza));

        System.out.println();

        System.out.println("Cuantos vuelos salieron de Milan: ");
        System.out.println(estadisticas.cantidadDeVuelosQueSalieronDe(aeropuertoMilan));

        System.out.println("Cuantos vuelos salieron de Barcelona: ");
        System.out.println(estadisticas.cantidadDeVuelosQueSalieronDe(aeropuertoBarcelona));

        System.out.println("Cuantos vuelos salieron de Buenos Aires: ");
        System.out.println(estadisticas.cantidadDeVuelosQueSalieronDe(aeropuertoEzeiza));


        System.out.println("Aeropuerto con menos escalas");
        System.out.println(
                estadisticas.obtenerAeropuertoConMenosEscalas(
                    Arrays.asList(aeropuertoBarcelona,aeropuertoMilan,aeropuertoEzeiza)
            )
        );


        System.out.println("Cantidad de aeropuertos en Ezeiza");
        System.out.println(bsAs.getAeropuertos().size());


        System.out.println("Ciudad que arribo mas pasajeros");
        System.out.println(estadisticas.obtenerCiudadQueRecibioMasPasajerosEnUnDia(Arrays.asList(
                milan,bsAs,barcelona
        ), LocalDate.now()));


        System.out.println("Cantidad de vuelos que realizo una tripulacion en tres meses: ");
        System.out.println(estadisticas.cantidadDeVuelosQueRealizoUnaTripulacionEn(3,tripulacion));

        System.out.println("Aerolinea con mayor cantidad de pasajeros: ");
        System.out.println(estadisticas.obtenerAerolineaConMayorPasajerosEnMes(Arrays.asList(aerolinea,aerolinea1),3).get());

    }

    private static List<Tripulante> obtenerTripulacion(){
        return Arrays.asList(
                new Tripulante("Piloto 1", RolTripulante.PILOTO),
                new Tripulante("Piloto 2", RolTripulante.PILOTO),
                new Tripulante("Operador de comunicacoines", RolTripulante.OPERADOR_DE_COMUNICACIONES),
                new Tripulante("Comisario a bordo 1", RolTripulante.COMISARIO_A_BORDO),
                new Tripulante("Comisario a bordo 2", RolTripulante.COMISARIO_A_BORDO),
                new Tripulante("Azafata 1", RolTripulante.AZAFATA),
                new Tripulante("Azafata 2", RolTripulante.AZAFATA),
                new Tripulante("Azafata 3", RolTripulante.AZAFATA),
                new Tripulante("Azafata 4", RolTripulante.AZAFATA)
        );
    }
}
