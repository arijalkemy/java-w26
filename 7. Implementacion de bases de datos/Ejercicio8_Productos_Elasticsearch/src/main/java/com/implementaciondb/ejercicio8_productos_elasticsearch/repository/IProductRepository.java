package com.implementaciondb.ejercicio8_productos_elasticsearch.repository;

import com.implementaciondb.ejercicio8_productos_elasticsearch.model.domain.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IProductRepository extends ElasticsearchRepository<Product, String> {


}
