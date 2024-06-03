package com.meli.elastic.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArticuloRepository extends ElasticsearchRepository<> {
}
