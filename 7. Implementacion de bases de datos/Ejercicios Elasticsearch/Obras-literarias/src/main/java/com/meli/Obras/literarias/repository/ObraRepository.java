package com.meli.Obras.literarias.repository;

import com.meli.Obras.literarias.model.Obra;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObraRepository extends ElasticsearchRepository<Obra, String> {

    List<Obra> findByAutor(String autor);

    List<Obra> findByNombreLike(String titulo);

    List<Obra> findAllByOrderByCantidadDePaginasDesc();

    List<Obra> findByFechaPublicacionLessThanEqual(int anio);

    List<Obra> findByEditorial(String editorial);
}
