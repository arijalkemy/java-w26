package repositorios;

import modelo.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RepositorioVuelos {

    List<Vuelo> vuelos = new ArrayList<>();


    public void agregarVuelo(Vuelo vuelo) {
        this.vuelos.add(vuelo);
    }


    public int cantidadDeVuelosQueLlegaronA(Aeropuerto aeropuerto) {
        return this.vuelos.stream().filter(v -> {
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
        return this.vuelos.stream().filter(v -> {
            boolean llegoAEseAeropuerto = v.getAeropuertoInicio().equals(aeropuerto);
            if (llegoAEseAeropuerto) {
                return true;
            } else {
                if (v.getTipoDeVuelo() instanceof VueloConEscalas) {
                    // Verifico que haya sido llegada de alguna escala
                    return ((VueloConEscalas) v.getTipoDeVuelo()).getEscalas().stream().anyMatch(e -> e.getAeropuertoInicio().equals(aeropuerto));
                } else {
                    return false;
                }
            }
        }).toList().size();
    }

    public Aeropuerto obtenerAeropuertoConMenosEscalas(List<Aeropuerto> aeropuertos) {
        List<Escala> escalas = this.vuelos.stream().filter(v -> v.getTipoDeVuelo() instanceof VueloConEscalas)
                .flatMap(v -> ((VueloConEscalas) v.getTipoDeVuelo()).getEscalas().stream()).toList();
        return aeropuertos.stream()
                .min(Comparator.comparingInt(a -> (int) escalas.stream()
                        .filter(e -> e.getAeropuertoLlegada().equals(a))
                        .count())).get();
    }

    public Ciudad obtenerCiudadQueRecibioMasPasajeros(List<Ciudad> ciudades) {
        return ciudades.stream().max(Comparator.comparingInt(ciudad -> this.vuelos.stream().filter(v -> {
            System.out.println(ciudad);
                    boolean llegoAEseAeropuerto = v.getAeropuertoLlegada().getCiudad().equals(ciudad);
                    if (llegoAEseAeropuerto) {
                        return true;
                    } else {
                        if (v.getTipoDeVuelo() instanceof VueloConEscalas) {
                            return ((VueloConEscalas) v.getTipoDeVuelo()).getEscalas().stream()
                                    .anyMatch(e -> e.getAeropuertoLlegada().getCiudad().equals(ciudad));
                        } else {
                            return false;
                        }
                    }
                }).mapToInt(v -> {
                    return v.getPasajeros().size();
                }).sum()
        )).get();

    }

}
