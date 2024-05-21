package com.example.productoselastic.repository;

import com.example.productoselastic.models.Product;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends ElasticsearchRepository<Product, String> {
    List<Product> findAll();
}
