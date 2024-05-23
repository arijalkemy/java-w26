package com.ejercicio.showroomnosql.repository;

import com.ejercicio.showroomnosql.entity.Clothe;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ClotheRepository extends ElasticsearchRepository<Clothe, String> {
}
