package org.responseentity.productos.repository;

import org.responseentity.productos.model.Producto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends ElasticsearchRepository<Producto, String> {
    List<Producto> findAll();
}
