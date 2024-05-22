package org.ejercicio.apiobrasliterarias.repositories;

import org.ejercicio.apiobrasliterarias.models.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {
    List<ObraLiteraria> findAll();
    List<ObraLiteraria> findByAutor(String autor);
    List<ObraLiteraria> findByNombreContainingIgnoreCase(String nombre);
    List<ObraLiteraria> findTop5ByOrderByCantidadDePaginasDesc();
    List<ObraLiteraria> findByAnioPrimeraPublicacionBefore(Integer anioPrimeraPublicacion);
    List<ObraLiteraria> findByEditorial(String editorial);
}
