package org.example.productoelastic.repository;

import org.example.productoelastic.entity.Producto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductoRepository extends ElasticsearchRepository<Producto, Long> {
}
