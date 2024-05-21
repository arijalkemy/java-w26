package com.example.elastic.repository;

import com.example.elastic.model.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EmpleadoRepository extends ElasticsearchRepository<Empleado, Integer> {
}
