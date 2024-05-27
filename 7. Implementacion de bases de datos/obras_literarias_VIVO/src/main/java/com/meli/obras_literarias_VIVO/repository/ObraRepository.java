package com.meli.obras_literarias_VIVO.repository;

import com.meli.obras_literarias_VIVO.entities.Obra;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ObraRepository extends ElasticsearchRepository<Obra, String> {
    List<Obra> findAll();
    List<Obra> findByAutor(String autor);
    List<Obra> findByNombre(String nombre);
    List<Obra> findTop5ByOrderByCantidadDePaginasDesc();
    List<Obra> findByAñoGreaterThan(Integer age);
}
