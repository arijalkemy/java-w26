package org.example.obrasliterariaselastic.Repository;

import org.example.obrasliterariaselastic.Model.ObraLiteraria;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {
    List<ObraLiteraria> findAll();

    @Query("{\"bool\": {\"must\": [{\"match \": {\"autor\": \"?\"} }] }}")
    List<ObraLiteraria> findByAutor(String autor);

    List<ObraLiteraria> findByNombreContains(String keyword);

    List<ObraLiteraria> findTop5ByOrderByCantidadDePaginasDesc();

    @Query("{\"bool\": {\"must\": [{\"range\": {\"anio_primera_publicacion\": {\"lt\": ?0}}] }}")
    List<ObraLiteraria> findByAnioPrimeraPublicacionIsLessThan(Integer anio);

    List<ObraLiteraria> findByEditorial(String editorial);
}
