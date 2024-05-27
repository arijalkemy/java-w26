package org.example.tiendadeprendas.repository;

import org.example.tiendadeprendas.model.Prenda;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPrendaRepository extends ElasticsearchRepository<Prenda, String> {
    List<Prenda> findPrendasByTalla(String size);
    List<Prenda> findByNombre(String nombre);
    List<Prenda> findByCodigo(String codigo);
}
