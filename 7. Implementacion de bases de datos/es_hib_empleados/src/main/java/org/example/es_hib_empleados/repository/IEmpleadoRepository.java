package org.example.es_hib_empleados.repository;

import org.example.es_hib_empleados.model.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado, String> {
    @Override
    List<Empleado> findAll();
}
