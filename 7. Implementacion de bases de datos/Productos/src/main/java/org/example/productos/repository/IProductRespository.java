package org.example.productos.repository;

import org.example.productos.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRespository extends ElasticsearchRepository<Product,String> {
    List<Product> findAll();
    Page<Product> findAllByTypeContainingIgnoreCase(String type, Pageable pageable);
}
