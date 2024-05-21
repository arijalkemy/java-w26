package meli.bootcamp.obrasliterarias.service;

import meli.bootcamp.obrasliterarias.model.ObraLiteraria;

import java.util.List;

public interface IObraService {
    ObraLiteraria create(ObraLiteraria obraLiteraria);

    List<ObraLiteraria> getObraLiterariasByAutor(String autor);

    List<ObraLiteraria> getObraLiterariasByNombreContaining(String contenido);

    List<ObraLiteraria> getTop5ByOrderByCantidadPaginasDesc();

    List<ObraLiteraria> getAllByAnioPrimeraPublicacionBefore(Integer year);

    List<ObraLiteraria> getAllByEditorialEqualsIgnoreCase(String editorial);
}
