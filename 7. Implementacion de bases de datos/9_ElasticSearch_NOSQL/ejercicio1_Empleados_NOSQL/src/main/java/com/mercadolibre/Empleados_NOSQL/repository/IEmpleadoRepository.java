package com.mercadolibre.Empleados_NOSQL.repository;

import com.mercadolibre.Empleados_NOSQL.model.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado, String> {
    List<Empleado> findAll();
}
