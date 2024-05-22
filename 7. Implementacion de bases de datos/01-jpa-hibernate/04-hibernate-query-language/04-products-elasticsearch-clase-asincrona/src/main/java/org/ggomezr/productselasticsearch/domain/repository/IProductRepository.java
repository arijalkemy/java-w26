package org.ggomezr.productselasticsearch.domain.repository;

import org.ggomezr.productselasticsearch.domain.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends ElasticsearchRepository<Product, String>{
}
