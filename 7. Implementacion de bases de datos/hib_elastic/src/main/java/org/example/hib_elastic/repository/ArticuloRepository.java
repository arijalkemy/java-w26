package org.example.hib_elastic.repository;

import org.example.hib_elastic.domain.Articulo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticuloRepository extends ElasticsearchRepository<Articulo, String> {
}
