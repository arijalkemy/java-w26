package com.empleadoselastic.repositories;

import com.empleadoselastic.models.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado, String>{
    List<Empleado> findAll();
}
