package org.example.empleadoselastic.repository;

import org.example.empleadoselastic.entity.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado, Long> {
}
