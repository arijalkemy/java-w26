package org.bootcamp.implementacionnosql_producto.repository;

import org.bootcamp.implementacionnosql_producto.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product, String> {
}
