package org.implementaciondb.ejemplo7_elasticsearch.repository;

import org.implementaciondb.ejemplo7_elasticsearch.domain.Articulo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IArticuloRepository extends ElasticsearchRepository<Articulo, String> {
}
