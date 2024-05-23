package org.miprimerproyecto.elasticproduct.repository;

import org.miprimerproyecto.elasticproduct.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface productRepository extends ElasticsearchRepository<Product, String> {
    List<Product> findAll();
}
