package servicios;

import enums.Mes;
import modelo.*;
import repositorios.RepositorioVuelos;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class Estadisticas {

    private RepositorioVuelos repositorioVuelos;

    public Estadisticas() {
        this.repositorioVuelos = RepositorioVuelos.obtenerInstancia();
    }

    public int cantidadDeVuelosQueLlegaronA(Aeropuerto aeropuerto) {

        List<Vuelo> vuelos = this.repositorioVuelos.obtenerVuelos();

        return vuelos.stream().filter(v -> {
            boolean llegoAEseAeropuerto = v.getAeropuertoLlegada().equals(aeropuerto);
            if (llegoAEseAeropuerto) {
                return true;
            } else {
                if (v.getTipoDeVuelo() instanceof VueloConEscalas) {
                    // Verifico que haya sido llegada de alguna escala
                    return ((VueloConEscalas) v.getTipoDeVuelo()).getEscalas().stream().anyMatch(e -> e.getAeropuertoLlegada().equals(aeropuerto));
                } else {
                    return false;
                }
            }
        }).toList().size();
    }

    public int cantidadDeVuelosQueSalieronDe(Aeropuerto aeropuerto) {
        List<Vuelo> vuelos = this.repositorioVuelos.obtenerVuelos();

        return vuelos.stream().filter(v -> {
            boolean llegoAEseAeropuerto = v.getAeropuertoInicio().equals(aeropuerto);
            if (llegoAEseAeropuerto) {
                return true;
            } else {
                if (v.getTipoDeVuelo() instanceof VueloConEscalas) {
                    // Verifico que haya sido llegada de alguna escala
                    return ((VueloConEscalas) v.getTipoDeVuelo())
                            .getEscalas()
                            .stream()
                            .anyMatch(e -> e.getAeropuertoInicio().equals(aeropuerto));
                } else {
                    return false;
                }
            }
        }).toList().size();
    }

    public Aeropuerto obtenerAeropuertoConMenosEscalas(List<Aeropuerto> aeropuertos) {
        List<Vuelo> vuelos = this.repositorioVuelos.obtenerVuelos();

        List<Escala> escalas = vuelos
                                    .stream()
                                    .filter(v -> v.getTipoDeVuelo() instanceof VueloConEscalas)
                                    .flatMap(v -> ((VueloConEscalas) v.getTipoDeVuelo()).getEscalas().stream())
                                    .toList();
        return aeropuertos
                .stream()
                .min(Comparator.comparingInt(a -> (int) escalas.stream()
                        .filter(e -> e.getAeropuertoLlegada().equals(a))
                        .count()))
                .get();
    }

    public Ciudad obtenerCiudadQueRecibioMasPasajerosEnUnDia(List<Ciudad> ciudades, LocalDate fecha) {
        List<Vuelo> vuelos = this.repositorioVuelos.obtenerVuelos();

        return ciudades.stream().max(Comparator.comparingInt(ciudad -> vuelos.stream().filter(v -> {
                    boolean llegoAEseAeropuerto = v.getAeropuertoLlegada().getCiudad().equals(ciudad)
                            && v.getFechaLLegada().equals(fecha);
                    if (llegoAEseAeropuerto) {
                        return true;
                    } else {
                        if (v.getTipoDeVuelo() instanceof VueloConEscalas) {
                            return ((VueloConEscalas) v.getTipoDeVuelo()).getEscalas().stream()
                                    .anyMatch(e -> e.getAeropuertoLlegada().getCiudad().equals(ciudad)
                                            && e.getFechaLlegada().equals(fecha));
                        } else {
                            return false;
                        }
                    }
                }).mapToInt(v -> {
                    return v.getPasajeros().size();
                }).sum()
        )).get();

    }

    public int cantidadDeVuelosQueRealizoUnaTripulacionEn(int meses, List<Tripulante> tripulacion){
        LocalDate hasta = LocalDate.now();
        LocalDate desde = hasta.minusMonths(meses);

        List<Vuelo> vuelos = repositorioVuelos.obtenerVuelos();


        return vuelos
                .stream()
                .filter(v -> v.getTripulacion().equals(tripulacion) &&
                        hasta.isAfter(v.getFechaLLegada()) &&
                        desde.isBefore(v.getFechaLLegada()))
                .toList()
                .size();
    }

}
