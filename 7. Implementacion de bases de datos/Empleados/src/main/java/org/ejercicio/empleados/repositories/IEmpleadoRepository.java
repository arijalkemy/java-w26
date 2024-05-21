package org.ejercicio.empleados.repositories;

import org.ejercicio.empleados.models.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado, String> {

}
