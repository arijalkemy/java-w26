package org.example.elastic.repository;

import org.example.elastic.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IProductRepository extends ElasticsearchRepository<Product, String> {
}
