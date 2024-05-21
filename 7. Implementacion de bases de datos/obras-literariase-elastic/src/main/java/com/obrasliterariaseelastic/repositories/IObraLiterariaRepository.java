package com.obrasliterariaseelastic.repositories;

import com.obrasliterariaseelastic.models.ObraLiteraria;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {
    List<ObraLiteraria> findByAutor(String author);

    @Query("{\"match\": {\"name\": \"?0\"}}")
    List<ObraLiteraria> findByTitleContaining(String title);
    List<ObraLiteraria> findTop5ByOrderByCantPaginasDesc();
    List<ObraLiteraria> findByAnioPublicacionBefore(Integer anio);
    List<ObraLiteraria> findByEditorial(String editorial);
}
