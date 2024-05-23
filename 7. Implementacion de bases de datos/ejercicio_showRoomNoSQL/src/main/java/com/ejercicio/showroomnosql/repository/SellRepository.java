package com.ejercicio.showroomnosql.repository;

import com.ejercicio.showroomnosql.entity.Sell;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SellRepository extends ElasticsearchRepository<Sell, String> {
}
