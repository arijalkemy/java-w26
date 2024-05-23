package org.example.ejercicios_extra_elasticsearch.repository;

import org.example.ejercicios_extra_elasticsearch.model.Prenda;
import org.example.ejercicios_extra_elasticsearch.model.Venta;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPrendaRepository extends ElasticsearchRepository<Prenda, String> {
    List<Prenda> findAll();
    List<Prenda> findByTalle(String talle);
    List<Prenda> findByNombreContainingIgnoreCase(String nombre);
}
