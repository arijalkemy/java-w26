package com.demospring.ejerciciodeempleados.repository;

import com.demospring.ejerciciodeempleados.model.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado, String>{
    List<Empleado> findAll();
}
