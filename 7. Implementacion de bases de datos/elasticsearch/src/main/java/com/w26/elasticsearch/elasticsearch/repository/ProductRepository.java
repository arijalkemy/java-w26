package com.w26.elasticsearch.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.w26.elasticsearch.elasticsearch.entity.Product;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {
    
}
