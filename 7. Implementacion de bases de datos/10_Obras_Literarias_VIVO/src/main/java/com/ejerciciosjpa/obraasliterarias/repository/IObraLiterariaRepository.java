package com.ejerciciosjpa.obraasliterarias.repository;

import com.ejerciciosjpa.obraasliterarias.domain.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria,String> {
    List<ObraLiteraria> findAll();
    List<ObraLiteraria> findAllByAutor(String autor);
    List<ObraLiteraria> findAllByNombre(String clave);
    List<ObraLiteraria> findTop5ByOrderByCantidadDePaginasDesc();
    List<ObraLiteraria> findAllByPrimeraPublicacionIsLessThan(Integer year);
    List<ObraLiteraria> findAllByEditorial(String editorial);
}
