package org.example.elasticksearch.repository;

import org.example.elasticksearch.domain.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EmpleadoRepository extends ElasticsearchRepository<Empleado, String> {
}
