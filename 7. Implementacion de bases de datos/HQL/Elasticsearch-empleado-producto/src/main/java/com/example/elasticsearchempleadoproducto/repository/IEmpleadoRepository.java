package com.example.elasticsearchempleadoproducto.repository;

import com.example.elasticsearchempleadoproducto.model.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado, Long> {
}
