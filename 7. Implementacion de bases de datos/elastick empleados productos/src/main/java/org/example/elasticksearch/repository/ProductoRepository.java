package org.example.elasticksearch.repository;

import org.example.elasticksearch.domain.Producto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends ElasticsearchRepository<Producto, String> {
}
