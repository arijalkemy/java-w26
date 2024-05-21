package org.example.obrasliterariaselastic.Service;

import org.example.obrasliterariaselastic.DTO.ObraLiterariaDTOResponse;

import java.time.LocalDate;
import java.util.List;

public interface IObrasLiterariasService {
    List<ObraLiterariaDTOResponse> obtenerTodas();

    List<ObraLiterariaDTOResponse> obtenerDeAutor(String autor);

    List<ObraLiterariaDTOResponse> obtenerPorTituloContiene(String keyword);

    List<ObraLiterariaDTOResponse> obtenerTop5ObrasConMasPaginasOrdenadas();

    List<ObraLiterariaDTOResponse> obtenerPorAnioPrimeraPublicacionMenorA(Integer anio);

    List<ObraLiterariaDTOResponse> obtenerPorEditorial(String editorial);
}
