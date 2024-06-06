package org.example.integradorproductemployee.repository;

import org.example.integradorproductemployee.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends ElasticsearchRepository<Product, String> {
}
