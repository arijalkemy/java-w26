package org.example.ejercicios_extra_elasticsearch.repository;

import org.example.ejercicios_extra_elasticsearch.model.Venta;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVentaRepository extends ElasticsearchRepository<Venta, String> {
    List<Venta> findAll();
}
