package com.example.empleados_spring_data_elastic.repository;

import com.example.empleados_spring_data_elastic.domain.Empleado;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EmpleadoRepository extends ElasticsearchRepository<Empleado, String> {

    List<Empleado> findAll();
}
