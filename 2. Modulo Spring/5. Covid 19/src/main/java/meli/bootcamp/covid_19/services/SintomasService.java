package meli.bootcamp.covid_19.services;

import java.util.List;
import meli.bootcamp.covid_19.domain.NivelDeGravedad;
import meli.bootcamp.covid_19.domain.Sintoma;
import meli.bootcamp.covid_19.dto.SintomaDto;
import meli.bootcamp.covid_19.repositories.RepositorioSintomas;
import org.springframework.stereotype.Service;

@Service
public class SintomasService {
  RepositorioSintomas repositorioSintomas;

  public SintomasService() {
    this.repositorioSintomas = new RepositorioSintomas(
        List.of(
            new Sintoma("a123", "Tos seca", NivelDeGravedad.LEVE),
            new Sintoma("b123", "Fiebre", NivelDeGravedad.MODERADO),
            new Sintoma("c123", "Cansancio", NivelDeGravedad.MODERADO),
            new Sintoma("d123", "Dolor de garganta", NivelDeGravedad.LEVE),
            new Sintoma("e123", "Diarrea", NivelDeGravedad.GRAVE),
            new Sintoma("f123", "Conjuntivitis", NivelDeGravedad.GRAVE),
            new Sintoma("g123", "Dolor de cabeza", NivelDeGravedad.MODERADO)
        )
    );
  }

  public List<SintomaDto> obtenerSintomas() {
    return this.repositorioSintomas.obtenerSintomas().stream()
        .map(sintoma -> new SintomaDto(sintoma.getNombre(), sintoma.getNivelDeGravedad().name()))
        .toList();
  }

  public List<SintomaDto> obtenerSintomaPorNombre(String nombre) {
    return this.repositorioSintomas.obtenerSintomaPorNombre(nombre).stream()
        .map(sintoma -> new SintomaDto(sintoma.getNombre(), sintoma.getNivelDeGravedad().name()))
        .toList();
  }

}
