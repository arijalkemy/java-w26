package com.example.ejercicio_implementacion_nosql_empleados.repository;

import com.example.ejercicio_implementacion_nosql_empleados.model.domain.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado, Long> {
}
