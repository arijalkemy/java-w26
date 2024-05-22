package org.ejercicio.apiobrasliterarias.services;

import org.ejercicio.apiobrasliterarias.dtos.ObraLiterariaDto;
import org.ejercicio.apiobrasliterarias.dtos.ObraLiterariaRequestDto;

import java.time.LocalDate;
import java.util.List;

public interface IObraLiterariaService {
    List<ObraLiterariaDto> findByAutor(String autor);
    List<ObraLiterariaDto> findByNombreContainingIgnoreCase(String nombre);
    List<ObraLiterariaDto> findTop5ByOrderByCantidadDePaginasDesc();
    List<ObraLiterariaDto> findByAnioPrimeraPublicacionBefore(Integer anioPrimeraPublicacion);
    List<ObraLiterariaDto> findByEditorial(String editorial);
    ObraLiterariaDto save(ObraLiterariaRequestDto obraLiterariaRequestDto);
    List<ObraLiterariaDto> saveAll(List<ObraLiterariaDto> obrasLiterariaDtos);
}
