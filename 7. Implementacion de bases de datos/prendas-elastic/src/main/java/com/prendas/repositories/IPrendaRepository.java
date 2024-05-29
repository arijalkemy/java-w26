package com.prendas.repositories;

import com.prendas.models.Prenda;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPrendaRepository extends ElasticsearchRepository<Prenda, String> {
    List<Prenda> findAll();
    List<Prenda> findByTalle(String size);
    List<Prenda> findByNombre(String nombre);
}
