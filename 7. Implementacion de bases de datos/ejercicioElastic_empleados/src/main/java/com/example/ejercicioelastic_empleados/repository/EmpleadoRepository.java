package com.example.ejercicioelastic_empleados.repository;

import com.example.ejercicioelastic_empleados.entities.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EmpleadoRepository extends ElasticsearchRepository<Empleado, String> {

}
