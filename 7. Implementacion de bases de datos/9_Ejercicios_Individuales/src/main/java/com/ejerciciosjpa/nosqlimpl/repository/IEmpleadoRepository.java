package com.ejerciciosjpa.nosqlimpl.repository;

import com.ejerciciosjpa.nosqlimpl.domain.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado,String> {
    List<Empleado> findAll();
}
