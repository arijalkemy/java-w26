package com.prendaselastic.repositories;

import com.prendaselastic.models.Prenda;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPrendaRepository extends ElasticsearchRepository<Prenda, String> {
    List<Prenda> findAll();
    @Query("{\"match\": {\"talle\": \"?0\"}}")
    List<Prenda> findByTalle(String size);
    @Query("{\"match\": {\"nombre\": \"?0\"}}")
    List<Prenda> findByNombre(String nombre);
}
