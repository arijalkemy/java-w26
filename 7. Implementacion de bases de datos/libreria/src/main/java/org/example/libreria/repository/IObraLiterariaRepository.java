package org.example.libreria.repository;

import org.example.libreria.entity.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {

    List<ObraLiteraria> findByAutorContaining(String nombre);

    List<ObraLiteraria> findByNombreContaining(String nombre);

    List<ObraLiteraria> findTop5ByOrderByCantidadPaginasDesc();

    List<ObraLiteraria> findByAnioPublicacionBefore(Integer anioPublicacion);

    List<ObraLiteraria> findByEditorial(String editorial);
}