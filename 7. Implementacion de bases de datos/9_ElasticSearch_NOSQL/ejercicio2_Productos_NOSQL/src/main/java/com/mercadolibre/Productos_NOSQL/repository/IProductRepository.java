package com.mercadolibre.Productos_NOSQL.repository;

import com.mercadolibre.Productos_NOSQL.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends ElasticsearchRepository<Product,String> {
    public List<Product> findAll();
}
