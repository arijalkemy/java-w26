package com.bootcamp.products.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.bootcamp.products.model.Product;

import java.util.List;

public interface IProductRepository extends ElasticsearchRepository<Product, String> {

    List<Product> findAll();

}
