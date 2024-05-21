package com.example.elastic.repository;

import com.example.elastic.domain.Product;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProductRepository extends ElasticsearchRepository<Product, Integer> {

    @Query ("{\n" +
            "  \"query\": {\n" +
            "    \"match_all\": {}\n" +
            "  }")
    public List<Product> findAll();

}
