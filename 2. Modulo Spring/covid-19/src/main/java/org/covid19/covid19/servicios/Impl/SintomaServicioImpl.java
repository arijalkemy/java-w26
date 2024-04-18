package org.covid19.covid19.servicios.Impl;

import org.covid19.covid19.dto.SintomaDto;
import org.covid19.covid19.entidades.NivelDeGravedad;
import org.covid19.covid19.entidades.Sintoma;
import org.covid19.covid19.repositorios.RepositorioSintoma;
import org.covid19.covid19.servicios.ISintomaServicio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SintomaServicioImpl implements ISintomaServicio {

    RepositorioSintoma repositorioSintoma;

    public SintomaServicioImpl() {
        this.repositorioSintoma = new RepositorioSintoma(
                List.of(
                        new Sintoma("arn123", "Fiebre", NivelDeGravedad.MEDIO),
                        new Sintoma("arn1234", "Dolor de garganta", NivelDeGravedad.LEVE),
                        new Sintoma("arn12345", "Dificultad para respirar", NivelDeGravedad.GRAVE)
                )
        );
    }

    public List<SintomaDto> obtenerTodosLosSintomas() {
        return this.repositorioSintoma.obtenerSintomas().stream()
                //.map(sintoma -> new SintomaDto(sintoma.getNombre(), sintoma.getNivel_de_gravedad().name()))
                .map(this::crearSintomaDto)
                .toList();
    }

    public List<SintomaDto> obtenerSintomaPorNombre(String nombre) {
        List<Sintoma> sintomas = this.repositorioSintoma.obtenerSintomas().stream()
                .filter(s -> s.getNombre().toLowerCase().equals(nombre.toLowerCase())).toList();
        return sintomas.stream().map(this::crearSintomaDto).toList();
    }

    public SintomaDto crearSintomaDto(Sintoma sintoma) {
        return new SintomaDto(sintoma.getNombre(), sintoma.getNivel_de_gravedad().name().toLowerCase());
    }

}
